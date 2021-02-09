package com.hillel.task17.task7_forTest.task7;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Recursion recursion = new Recursion();
        recursion.printArrByRecursion(arr);

        IntList list = new ListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(6);

    }
}
