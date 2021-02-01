package com.hillel;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
//method isEmpty
        System.out.println(CollectionUtils.isEmpty(null));
        System.out.println(CollectionUtils.isEmpty(integers));
        integers.add(1);
        integers.add(12);
        integers.add(14);
        System.out.println(CollectionUtils.isEmpty(integers));
        System.out.println(CollectionUtils.isNotEmpty(integers));

//method reverse
        Integer [] arr = new Integer[integers.size()];
        CollectionUtils.reverseArray(integers.toArray(arr));
        integers = Arrays.asList(arr);
        System.out.println(integers);
    }
}
