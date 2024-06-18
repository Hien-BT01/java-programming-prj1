package constant;

import java.util.List;
import java.util.regex.Pattern;

public class Constant {
    private static final String WELCOME_MENU_FIRST = "Find and reserve a room";

    private static final String WELCOME_MENU_SECOND = "See my reservations";

    private static final String WELCOME_MENU_THIRD = "Create an account";

    private static final String WELCOME_MENU_FOURTH = "Admin";

    private static final String WELCOME_MENU_FIFTH = "Exit";

    private static final String ADMIN_MENU_FIRST = "See all Customers";

    private static final String ADMIN_MENU_SECOND = "See all Rooms";

    private static final String ADMIN_MENU_THIRD = "See all Reservations";

    private static final String ADMIN_MENU_FOURTH = "Add a Room";

    private static final String ADMIN_MENU_FIFTH = "Add Test Data";

    private static final String ADMIN_MENU_SIXTH = "Back to Main Menu";

    public static List<String> MAIN_MENU = List.of(WELCOME_MENU_FIRST, WELCOME_MENU_SECOND, WELCOME_MENU_THIRD, WELCOME_MENU_FOURTH, WELCOME_MENU_FIFTH);
    public static List<String> ADMIN_MENU = List.of(ADMIN_MENU_FIRST, ADMIN_MENU_SECOND, ADMIN_MENU_THIRD, ADMIN_MENU_FOURTH, ADMIN_MENU_FIFTH, ADMIN_MENU_SIXTH);

    public static final String HYPHEN = "-";

    public static final Integer INT_ZERO = 0;

    public static final Integer INT_ONE = 1;

    public static final Integer INT_TWO = 2;

    public static final Integer INT_THREE = 3;

    public static final Integer INT_FOUR = 4;

    public static final Integer INT_FIVE = 5;

    public static final Integer INT_SIX = 6;

    public static final Integer INT_SEVEN = 7;

    public static final Integer INT_TEN = 10;

    public static final Integer INT_ELEVEN = 11;

    public static final Double FIFTY_PRICE = 50.00;

    public static final Double ONE_HUNDRED_PRICE = 100.00;

    public static final Double ZERO_PRICE = 0.00;

    public static final String NULL_VALUE_EXCEPTION = "Data can not be null";

    public static final String INVALID_DATETIME_EXCEPTION = "Invalid date time";

    public static final String INVALID_SINGLE_ROOM_EXCEPTION = "User can not reserve single room twice at the same time";

    public static final String UNIQUE_ROOM_NUMBER_EXCEPTION = "Room number must be unique";

    public static final String NO_RESERVATION_MESSAGE = "No reservations now";

    public static final String EXIT_PROGRAM_MESSAGE = "\nExit application ...\n";

    public static final String INPUT_CHECKIN_DATE_MESSAGE = "Enter checkIn date as format mm/dd/yyyy. CheckIn date must be after today, Ex: 01/20/2002:";

    public static final String INPUT_CHECKOUT_DATE_MESSAGE = "Enter checkOut date as format mm/dd/yyyy. Checkout date must be after checkin date, Ex: 01/20/2002:";

    public static final String INVALID_COMMON_DATE_MESSAGE = "Wrong format, please enter date as format mm/dd/yyyy";

    public static final String WRONG_DATE_FORMAT_MESSAGE = "Date must follow by mm/dd/yyyy format, please try again:";

    public static final String WELCOME_CHOOSE_OPTION_MESSAGE = "Please choose the option below:";

    public static final String CHOOSE_MAIN_MENU_OPTION_MESSAGE = "Please only choose number from 1 - 5\n";

    public static final String CHOOSE_ADMIN_MENU_OPTION_MESSAGE = "Please only choose number from 1 - 6\n";

    public static final String ENTER_EMAIL_MESSAGE = "Please enter your email as format abc@gmai.com: ";

    public static final String ENTER_FIRST_NAME_MESSAGE = "Please enter your first name, your first must must not be empty: ";

    public static final String ENTER_LAST_NAME_MESSAGE = "Please enter your last name age, your last name must must not be empty: ";

    public static final String NO_ROOM_MESSAGE = "There is no room in hotel now";

    public static final String ASKING_YES_NO = " Enter Y/YES, any other character for NO: ";

    public static final String INVALID_CHECKIN_DATE_VALUE = "Checkin date must be after today";

    public static final String INVALID_CHECKOUT_DATE_VALUE = "Checkout date must be after checkin date";

    public static final String INVALID_EMAIL_FORMAT = "Your email is not correct corresponding to format";

    public static final String INVALID_EMAIL_EXISTED = "Your entered email has been already existed, please enter the new one";

    public static final String INVALID_ROOM_NONEXISTED = "There is no room corresponding to your room number, please try again: ";

    public static final String YES = "Y,YES";

    private static final String EMAIL_REGEX = "^(.+)@(.+).(.+)$";

    public static final Pattern EMAIL_REGEX_PATTERN = Pattern.compile(EMAIL_REGEX);
}
