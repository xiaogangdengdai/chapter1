package org.smart4j.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    public ReflectionUtil() {
    }

    public static Object newInstance(Class<?> cls) {
        try {
            Object instance = cls.newInstance();
            return instance;
        } catch (Exception var3) {
            LOGGER.error("new instance failure", var3);
            throw new RuntimeException(var3);
        }
    }

    public static Object newInstance(String className) {
        Class<?> cls = ClassUtil.loadClass(className);
        return newInstance(cls);
    }

    public static Object invokeMethod(Object obj, Method method, Object... args) {
        try {
            method.setAccessible(true);
            Object result = method.invoke(obj, args);
            return result;
        } catch (Exception var5) {
            LOGGER.error("invoke method failure", var5);
            throw new RuntimeException(var5);
        }
    }

    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception var4) {
            LOGGER.error("set field failure", var4);
            throw new RuntimeException(var4);
        }
    }
}