package constant;

import java.util.List;
import java.util.regex.Pattern;

public class Constant {
    private static final String WELCOME_MENU_FIRST = "Find and reserve a room";
    private static final String WELCOME_MENU_SECOND = "See my reservations";
    private static final String WELCOME_MENU_THIRD = "Create an account";
    private static final String WELCOME_MENU_FOURTH = "Admin";
    private static final String WELCOME_MENU_FIFTH = "Exit";
    public static List<String> MAIN_MENU = List.of(WELCOME_MENU_FIRST, WELCOME_MENU_SECOND, WELCOME_MENU_THIRD, WELCOME_MENU_FOURTH, WELCOME_MENU_FIFTH);
    public static final String HYPHEN = "-";
    public static final Integer INT_ZERO = 0;
    public static final Integer INT_ONE = 1;
    public static final Integer INT_SEVEN = 7;
    public static final Integer INT_TEN = 10;
    public static final String NULL_VALUE_EXCEPTION = "Data can not be null";
    public static final String INVALID_DATETIME_EXCEPTION = "Invalid date time";
    public static final String INVALID_SINGLE_ROOM_EXCEPTION = "User can not reserve single room twice at the same time";

    public static final String UNIQUE_ROOM_NUMBER_EXCEPTION = "Room number must be unique";

    public static final String NO_RESERVATION_MESSAGE = "No reservations now";

    public static final String EXIT_PROGRAM_MESSAGE = "\nExit application ...\n";

    public static final String INPUT_CHECKIN_DATE_MESSAGE = "Enter checkIn date as format mm/dd/yyyy. CheckIn date must be after today, Ex: 01/20/2002:";
    public static final String INPUT_CHECKOUT_DATE_MESSAGE = "Enter checkOut date as format mm/dd/yyyy. Checkout date must be after checkin date, Ex: 01/20/2002:";
    public static final String WRONG_DATE_FORMAT_MESSAGE = "Date must follow by mm/dd/yyyy format, please try again:";

    public static final String INVALID_CHECKIN_DATE_VALUE = "Checkin date must be after today";

    public static final String INVALID_CHECKOUT_DATE_VALUE = "Checkout date must be after checkin date";

    public static final String WELCOME_CHOOSE_OPTION_MESSAGE = "Please choose the option below:";

    public static final String CHOOSE_MAIN_MENU_OPTION_MESSAGE = "Please choose number from 1 - 5\n";

    private static final String EMAIL_REGEX = "^(.+)@(.+).(.+)$";
    public static final Pattern EMAIL_REGEX_PATTERN = Pattern.compile(EMAIL_REGEX);
}
