package com.hillel.task21;

import java.util.ArrayList;
import java.util.List;

public class CountStringImpl implements CountString {

    public boolean isMoreTwoString(List<String> list) {
        List<String> subList = new ArrayList<>();
        for (String temp : list) {
            Character c = temp.charAt(0);
            if (Character.isUpperCase(c)) {
                subList.add(temp);
            }
        }
        return subList.size() > 2;
    }
}
