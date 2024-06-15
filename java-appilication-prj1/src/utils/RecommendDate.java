package utils;

import constant.Constant;

import java.util.Calendar;
import java.util.Date;

public class RecommendDate {
    public static Date plusSevenDays(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, Constant.INT_SEVEN);
        return calendar.getTime();
    }
}
