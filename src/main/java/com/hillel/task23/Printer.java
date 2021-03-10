package com.hillel.task23;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Printer<T> {

    void printField(T t) throws IllegalAccessException {
        Class<T> clazz = (Class<T>) t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field temp : fields) {
            if (!temp.isAnnotationPresent(Ignore.class)) {
                String mod = Modifier.toString(temp.getModifiers());
                String nameField = temp.getName();
                temp.setAccessible(true);
                Object value = temp.get(t);
                System.out.println(mod + "|" + nameField + "|" + value);
            }
        }
    }
}
