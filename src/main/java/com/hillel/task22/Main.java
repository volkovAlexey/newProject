package com.hillel.task22;

import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> {
            Random random = new Random();
            int rand = random.nextInt(10);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return rand;
        };

        Stream<Integer> integerStream = Stream.generate(supplier::apply).limit(100);

        integerStream.map(integer -> Math.pow(integer, 3))
                .filter((s) -> s > 100)
                .forEach(System.out::println);
    }
}
