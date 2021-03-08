package com.hillel.task23;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String s = "hello";
        Class<String> clazz = String.class;
        Constructor<String> constructor = clazz.getDeclaredConstructor(String.class);
        s = constructor.newInstance("ABCDE");

        User user = new User();
        Printer printer = (t)->{

        }
    }
}
