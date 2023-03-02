package com.solvd.project.carina.demo.components.utils;

import com.solvd.project.carina.demo.components.enums.Month;

public class DataFormatUtil {

    public static String formatToDate(int year, Month month, int day) {
        return String.format("%04d-%02d-%02d", year, month.getMonthNumber(), day);
    }
}
