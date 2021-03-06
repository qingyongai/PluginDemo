package com.qyai.activityplugin.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <b>Project:</b> PluginDemo <br>
 * <b>Create Date:</b> 2017/12/10 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b> 反射工具类 <br>
 */
public class ReflectUtil {

    public static Object getField(Class clazz, Object target, String name) throws Exception {
        Field field = clazz.getDeclaredField(name);
        field.setAccessible(true);
        return field.get(target);
    }

    public static Object getFieldNoException(Class clazz, Object target, String name) {
        try {
            return ReflectUtil.getField(clazz, target, name);
        } catch (Exception e) {
            //ignored.
        }
        return null;
    }

    public static void setField(Class clazz, Object target, String name, Object value) throws Exception {
        Field field = clazz.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    public static void setFieldNoException(Class clazz, Object target, String name, Object value) {
        try {
            ReflectUtil.setField(clazz, target, name, value);
        } catch (Exception e) {
            //ignored.
        }
    }

    @SuppressWarnings("unchecked")
    public static Object invoke(Class clazz, Object target, String name, Object... args)
            throws Exception {
        Class[] parameterTypes = null;
        if (args != null) {
            parameterTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = args[i].getClass();
            }
        }
        Method method = clazz.getDeclaredMethod(name, parameterTypes);
        method.setAccessible(true);
        return method.invoke(target, args);
    }

    @SuppressWarnings("unchecked")
    public static Object invoke(Class clazz, Object target, String name, Class[] parameterTypes, Object... args)
            throws Exception {
        Method method = clazz.getDeclaredMethod(name, parameterTypes);
        method.setAccessible(true);
        return method.invoke(target, args);
    }

    @SuppressWarnings("unchecked")
    public static Object invokeNoException(Class clazz, Object target, String name, Class[] parameterTypes, Object... args) {
        try {
            return invoke(clazz, target, name, parameterTypes, args);
        } catch (Exception e) {
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Object invokeConstructor(Class clazz, Class[] parameterTypes, Object... args)
            throws Exception {
        Constructor constructor = clazz.getDeclaredConstructor(parameterTypes);
        constructor.setAccessible(true);
        return constructor.newInstance(args);
    }
}
