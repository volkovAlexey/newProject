package com.hillel.task23;

import java.lang.reflect.Field;

public class Printer<T> {

    void printField(T t) {
        Class<T> clazz = T.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field temp: fields){
//            String mod = temp.getModifiers();
            String nameField = temp.getName();
        }

    }
}
