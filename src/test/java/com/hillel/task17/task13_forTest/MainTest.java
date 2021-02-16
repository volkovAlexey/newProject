package com.hillel.task17.task13_forTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainTest {
    DateTimeFormatter formatter;
    LocalDateTime dateForTest;
    String stringDate;

    @BeforeEach
    public void init() {
        formatter = DateTimeFormatter.ofPattern("yyyy/MMM/dd HH:mm:ss", Locale.UK);
        dateForTest = LocalDateTime.of(1993, 06, 22, 07, 34, 56);
        stringDate = "1993/Jun/22 07:34:56";
    }

    @Test
    public void parseStringToDate_ValidString() {
        String s = stringDate;
        LocalDateTime actualDate = Main.parseStringToDate(s, formatter);
        LocalDateTime expectedDate = dateForTest;
        Assertions.assertEquals(expectedDate, actualDate);
    }

    @Test
    public void convertDateToString_ValidDate() {
        LocalDateTime date = dateForTest;
        String actualString = Main.convertDateToString(date, formatter);
        String expectedString = stringDate;
        Assertions.assertEquals(expectedString, actualString);
    }
}
