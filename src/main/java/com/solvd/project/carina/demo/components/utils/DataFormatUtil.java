package com.solvd.project.carina.demo.components.utils;

import com.solvd.project.carina.demo.components.enums.Month;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataFormatUtil {

    public static String formatToDate(int year, Month month, int day) {
        LocalDate localDate = LocalDate.of(year, month.getMonthNumber(), day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(formatter);
    }
}
