package com.solvd.project.carina.demo.components.enums;

public enum Month {

    JANUARY("January", 1),
    FEBRUARY("February", 2),
    MARCH("March", 3),
    APRIL("April", 4),
    MAY("May", 5),
    JUNE("June", 6),
    JULY("July", 7),
    AUGUST("August", 8),
    SEPTEMBER("September", 9),
    OCTOBER("October", 10),
    NOVEMBER("November", 11),
    DECEMBER("December", 12);

    private final String monthName;

    private final int monthNumber;

    Month(String monthName, int monthNumber) {
        this.monthNumber = monthNumber;
        this.monthName = monthName;
    }

    public String getMonthName() {
        return monthName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }
}
