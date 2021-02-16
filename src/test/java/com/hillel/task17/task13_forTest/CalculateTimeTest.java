package com.hillel.task17.task13_forTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class CalculateTimeTest {
    private CalculateTime calculateTime;

    @BeforeEach
    public void init() {
        calculateTime = new CalculateTime();
    }

    @Test
    public void getPeriod_Time_Between_Dates() {
        LocalDateTime fromDate = LocalDateTime.now();
        LocalDateTime toDate = LocalDateTime.now().plusDays(1);
        String actualExpected = calculateTime.getPeriod(fromDate, toDate);
        String periodExpected = "days: 1 hours: 24 minutes: 1440 seconds: 86400";
        Assertions.assertEquals(periodExpected, actualExpected);
    }

    @Test
    public void getTime_Calculate_Time() {
        LocalTime start = LocalTime.now();
        LocalTime finish = LocalTime.now().plusHours(3);
        String actual = calculateTime.getTime(start, finish);
        String expected = "minutes: 180 seconds: 10800";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getTime_Calculate_Second_Value_Less_Than_First() {
        LocalTime start = LocalTime.now();
        LocalTime finish = LocalTime.now().minusHours(3);
        String actual = calculateTime.getTime(start, finish);
        String expected = "minutes: -180 seconds: -10800";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateMinutesInSeason_Valid_Name() {
        String season = "Winter";
        Long actualMinutes = calculateTime.calculateMinutesInSeason(season);
        Long expectedMinutes = 129599l;
        Assertions.assertEquals(expectedMinutes, actualMinutes);
    }

    @Test
    public void calculateMinutesInSeason_Name_IgnoreCase() {
        String season = "SUMMER";
        Long actualMinutes = calculateTime.calculateMinutesInSeason(season);
        Long expectedMinutes = 132479L;
        Assertions.assertEquals(expectedMinutes, actualMinutes);
    }
}
