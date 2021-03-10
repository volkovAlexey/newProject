package com.hillel.task23;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        String s = "hello";
        char[] arr = {'A', 'B', 'C', 'D', 'E'};
        Class<String> clazz = String.class;
        Field field = clazz.getDeclaredField("value");

        field.setAccessible(true);
        field.set(s, arr);
        System.out.println(s);

        User user = new User(12L, "Ivan", 22);
        Printer printer = new Printer();
        printer.printField(user);

    }
}
