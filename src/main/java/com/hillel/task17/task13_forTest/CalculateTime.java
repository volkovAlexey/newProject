package com.hillel.task17.task13_forTest;

import java.time.*;

public class CalculateTime {
    //#1
    public String getPeriod(LocalDateTime fromDate, LocalDateTime toDate) {
        Duration duration = Duration.between(fromDate, toDate);
        long days = duration.toDays();
        long seconds = duration.getSeconds();
        long minutes = duration.toMinutes();
        long hours = duration.toHours();
        return "days: " + days + " hours: " + hours + " minutes: " + minutes + " seconds: " + seconds;
    }

    //#2
    public String getTime(LocalTime start, LocalTime finish) {
        Duration duration = Duration.between(start, finish);
        return "minutes: " + duration.toMinutes() + " seconds: " + duration.getSeconds();
    }

    //#5
    public Long calculateMinutesInSeason(String seasonName) {
        Month startMonth;
        Month endMonth;
        if (seasonName.equalsIgnoreCase("Spring")) {
            startMonth = Month.MARCH;
            endMonth = Month.MAY;
            return minutesInSeason(startMonth, endMonth);
        }
        if (seasonName.equalsIgnoreCase("Summer")) {
            startMonth = Month.JUNE;
            endMonth = Month.AUGUST;
            return minutesInSeason(startMonth, endMonth);
        }
        if (seasonName.equalsIgnoreCase("Autumn")) {
            startMonth = Month.SEPTEMBER;
            endMonth = Month.NOVEMBER;
            return minutesInSeason(startMonth, endMonth);
        }
        if (seasonName.equalsIgnoreCase("Winter")) {
            startMonth = Month.DECEMBER;
            endMonth = Month.FEBRUARY;
            return minutesInWinter(startMonth, endMonth);
        }
        throw new IllegalArgumentException("Wrong name of season!");
    }

    private Long minutesInWinter(Month startMonth, Month endMonth) {
        LocalDateTime startDate;
        LocalDateTime endDate;
        int year = LocalDate.now().getYear();
        startDate = LocalDateTime.of(year - 1, startMonth, 1, 0, 0, 0);
        if (year % 4 == 0) {
            endDate = LocalDateTime.of(year, endMonth, endMonth.maxLength(), 23, 59, 59);
        } else {
            endDate = LocalDateTime.of(year, endMonth, endMonth.maxLength() - 1, 23, 59, 59);
        }
        return Duration.between(startDate, endDate).toMinutes();
    }

    private Long minutesInSeason(Month startMonth, Month endMonth) {
        LocalDateTime startDate;
        LocalDateTime endDate;
        int year = LocalDate.now().getYear();
        startDate = LocalDateTime.of(year, startMonth, 1, 0, 0, 0);
        endDate = LocalDateTime.of(year, endMonth, endMonth.maxLength(), 23, 59, 59);
        return Duration.between(startDate, endDate).toMinutes();
    }
}
