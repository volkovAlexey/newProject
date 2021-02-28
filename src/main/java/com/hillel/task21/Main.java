package com.hillel.task21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        List<Integer> list = new ArrayList<>();

        integers.stream().filter((i) -> {
            if (i % 2 == 0) {
                list.add(i * i);
            }
            return true;
        })
                .collect(Collectors.toList());
        System.out.println(list);

        List<String> strings = new ArrayList<>();
        strings.add("Sds");
        strings.add("aaa");
        strings.add("Aaadddd");
        strings.add("add");
        CountString countString = new CountStringImpl();

        Predicate<List<String>> predicate = s -> countString.isMoreTwoString(strings);
        System.out.println(predicate.test(strings));


    }
}
