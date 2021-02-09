package com.hillel.task17.task13_forTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        CalculateTime time = new CalculateTime();
        LocalDateTime fromDate = LocalDateTime.of(2021, 01, 18, 20, 00, 00);
        LocalDateTime toDate = LocalDateTime.of(2021, 01, 21, 22, 00, 00);
        System.out.println("Passed between lectures - " + time.getPeriod(fromDate, toDate));

        LocalTime start = LocalTime.of(20, 0, 0);
        LocalTime finish = LocalTime.of(22, 0, 0);
        System.out.println("Time in lecture - " + time.getTime(start, finish));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MMM/dd HH:mm:ss", Locale.UK);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm yyyy/MM/dd", Locale.UK);
        String s = "1993/Jun/22 07:34:56";

        System.out.println(parseStringToDate(s, formatter));

        System.out.println(convertDateToString(LocalDateTime.now(), formatter1));

        Long minutes = time.calculateMinutesInSeason("Summer");
        System.out.println(minutes);
    }

    //#3
    public static LocalDateTime parseStringToDate(String stringDate, DateTimeFormatter formatter) {
        LocalDateTime date = LocalDateTime.parse(stringDate, formatter);
        return date;
    }

    //#4
    public static String convertDateToString(LocalDateTime date, DateTimeFormatter formatter) {
        return date.format(formatter);
    }
}
