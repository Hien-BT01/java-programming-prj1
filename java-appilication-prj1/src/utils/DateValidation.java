package utils;

import constant.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidation {
    public static Date dateFormatValidation(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.parse(date);
    }

    public static boolean isValidReservationDate(Date checkInDate, Date checkOutDate){
        return checkInDate.compareTo(checkOutDate) <= Constant.INT_ZERO;
    }

    public static String formatDateString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(date);
    }
}
