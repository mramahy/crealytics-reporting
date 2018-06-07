package com.crealytics.reporting.utils;

public class MathUtil {

    public static Float getPercentage(Float dividend , Float divisor) {
        if(divisor == null || divisor == 0) return null;
        if(dividend == null) return null;

        return (dividend/divisor)*100;
    }
}
