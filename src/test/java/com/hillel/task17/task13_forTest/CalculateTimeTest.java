package com.hillel.task17.task13_forTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class CalculateTimeTest {
    private CalculateTime calculateTime;

    @Before
    public void init() {
        calculateTime = new CalculateTime();
    }

    @Test
    public void getPeriod_Time_Between_Dates() {
        LocalDateTime fromDate = LocalDateTime.now();
        LocalDateTime toDate = LocalDateTime.now().plusDays(1);
        String periodExpected = calculateTime.getPeriod(fromDate, toDate);
        String actual = "days: " + 1 + " hours: " + 24 + " minutes: " + 1440 + " seconds: " + 86400;
        Assert.assertEquals(periodExpected, actual);
    }

    @Test
    public void getTime_Calculate_Time() {
        LocalTime start = LocalTime.now();
        LocalTime finish = LocalTime.now().plusHours(3);
        String expected = calculateTime.getTime(start, finish);
        String actual = "minutes: " + 180 + " seconds: " + 10800;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTime_Calculate_Second_Value_Less_Than_First() {
        LocalTime start = LocalTime.now();
        LocalTime finish = LocalTime.now().minusHours(3);
        String expected = calculateTime.getTime(start, finish);
        String actual = "minutes: " + -180 + " seconds: " + -10800;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateMinutesInSeason_Valid_Name() {
        String season = "Winter";
        Long expectedMinutes = calculateTime.calculateMinutesInSeason(season);
        Long actual = 129599l;
        Assert.assertEquals(expectedMinutes, actual);
    }

    @Test
    public void calculateMinutesInSeason_Name_IgnoreCase() {
        String season = "SUMMER";
        Long expectedMinutes = calculateTime.calculateMinutesInSeason(season);
        Long actual = 132479L;
        Assert.assertEquals(expectedMinutes, actual);
    }
}
