package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidation {
    public static Date dateFormatValidation(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.parse(date);
    }

    public static boolean isValidReservationDate(Date checkInDate, Date checkOutDate){
        return checkInDate.before(checkOutDate);
    }
}
