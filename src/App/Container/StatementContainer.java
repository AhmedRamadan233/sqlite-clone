package App.Container;

import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class StatementContainer {
    private static final Map<String, StatementStrategyInterface> singletonBindings = new HashMap<>();
    private static final Map<String, Supplier<StatementStrategyInterface>> suppliers = new HashMap<>();
    private static final Map<Class<?>, Object> interfaceSingletonBindings = new HashMap<>();
    private static final Map<Class<?>, Supplier<?>> interfaceSuppliers = new HashMap<>();
    private static final Map<Class<?>, Object> dependencies = new HashMap<>();

    // ✳️ تسجيل dependencies
    public static void bindDependency(Class<?> type, Object instance) {
        dependencies.put(type, instance);
    }

    // ✳️ تسجيل singleton بالكلمة (مثلاً: "UPDATE")
    public static void Singlton(String command, Class<? extends StatementStrategyInterface> clazz) {
        try {
            StatementStrategyInterface instance = createInstance(clazz);
            singletonBindings.put(command.toUpperCase(), instance);
        } catch (Exception e) {
            throw new RuntimeException("Error creating singleton for: " + clazz.getName(), e);
        }
    }

    // ✳️ تسجيل singleton بـ interface (زي Laravel)
    public static <T> void Singlton(Class<T> iface, Class<? extends T> impl) {
        try {
            T instance = (T) createInstance(impl);
            interfaceSingletonBindings.put(iface, instance);
        } catch (Exception e) {
            throw new RuntimeException("Error binding interface: " + iface.getName(), e);
        }
    }

    // ✳️ تسجيل transient bind بالكلمة
    public static void Bind(String command, Class<? extends StatementStrategyInterface> clazz) {
        suppliers.put(command.toUpperCase(), () -> {
            try {
                return createInstance(clazz);
            } catch (Exception e) {
                throw new RuntimeException("Error creating instance for: " + clazz.getName(), e);
            }
        });
    }

    // ✳️ تسجيل transient bind بـ interface
    public static <T> void Bind(Class<T> iface, Class<? extends T> impl) {
        interfaceSuppliers.put(iface, () -> {
            try {
                return (T) createInstance(impl);
            } catch (Exception e) {
                throw new RuntimeException("Error binding interface transient: " + iface.getName(), e);
            }
        });
    }

    // ✳️ Resolve عن طريق command
    public static StatementStrategyInterface resolve(String command) {
        String key = command.toUpperCase().split(" ")[0];
        if (singletonBindings.containsKey(key)) {
            return singletonBindings.get(key);
        }
        if (suppliers.containsKey(key)) {
            return suppliers.get(key).get();
        }
        return null;
    }

    // ✳️ Resolve عن طريق interface
    public static <T> T resolve(Class<T> iface) {
        if (interfaceSingletonBindings.containsKey(iface)) {
            return (T) interfaceSingletonBindings.get(iface);
        }
        if (interfaceSuppliers.containsKey(iface)) {
            return (T) interfaceSuppliers.get(iface).get();
        }
        return null;
    }

    // ✳️ Factory لإنشاء instance مع دعم الـ dependencies
    private static <T> T createInstance(Class<?> clazz) throws Exception {
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            Class<?>[] paramTypes = constructor.getParameterTypes();
            Object[] args = new Object[paramTypes.length];
            boolean valid = true;
            for (int i = 0; i < paramTypes.length; i++) {
                if (dependencies.containsKey(paramTypes[i])) {
                    args[i] = dependencies.get(paramTypes[i]);
                } else {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return (T) constructor.newInstance(args);
            }
        }

        // fallback لـ constructor بدون arguments
        return (T) clazz.getConstructor().newInstance();
    }
}
