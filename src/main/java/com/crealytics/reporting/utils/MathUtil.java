package com.crealytics.reporting.utils;

import java.math.BigDecimal;

public class MathUtil {

    public static Float getPercentage(Float dividend , Float divisor) {
        if(divisor == null || divisor == 0) return null;
        if(dividend == null) return null;

        return round((dividend/divisor)*100,2);
    }

    public static float round(Float number, int decimalPlace) {
        BigDecimal bd = new BigDecimal(number.toString());
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public static double round(Double number, int decimalPlace) {
        BigDecimal bd = new BigDecimal(number.toString());
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
