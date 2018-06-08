package com.crealytics.reporting.domain.enums;

import java.time.DateTimeException;

public enum Month {

    JANUARY("January"),

    FEBRUARY("February"),

    MARCH("March"),

    APRIL("April"),

    MAY("May"),

    JUNE("June"),

    JULY("July"),

    AUGUST("August"),

    SEPTEMBER("September"),

    OCTOBER("October"),

    NOVEMBER("November"),

    DECEMBER("December");

    String value;

    Month(String value){
        this.value = value;
    }

    public static Month of(int month) {
        switch (month){
            case 1: return JANUARY;
            case 2: return FEBRUARY;
            case 3: return MARCH;
            case 4: return APRIL;
            case 5: return MAY;
            case 6: return JUNE;
            case 7: return JULY;
            case 8: return AUGUST;
            case 9: return SEPTEMBER;
            case 10: return OCTOBER;
            case 11: return NOVEMBER;
            case 12: return DECEMBER;
            default: throw new DateTimeException("Invalid value for MonthOfYear: " + month);
        }
    }

    public static Month of(String month) {
        switch (month){
            case "jan":
            case "january":
                return JANUARY;
            case "feb":
            case "february":
                return FEBRUARY;
            case "mar":
            case "march":
                return MARCH;
            case "apr":
            case "april":
                return APRIL;
            case "may":
                return MAY;
            case "jun":
            case "june":
                return JUNE;
            case "jul":
            case "july":
                return JULY;
            case "aug":
            case "august":
                return AUGUST;
            case "sep":
            case "september":
                return SEPTEMBER;
            case "oct":
            case "october":
                return OCTOBER;
            case "nov":
            case "november":
                return NOVEMBER;
            case "dec":
            case "december":
                return DECEMBER;
            default: throw new DateTimeException("Invalid value for Month: " + month);
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
