package constant;

import java.util.List;
import java.util.regex.Pattern;

public class Constant {
    private static final String WELCOME_MENU_FIRST = "Find and reserve a room";
    private static final String WELCOME_MENU_SECOND = "See my reservations";
    private static final String WELCOME_MENU_THIRD = "Create an account";
    private static final String WELCOME_MENU_FOURTH = "Admin";
    private static final String WELCOME_MENU_FIFTH = "Exit";
    public static List<String> WELCOME_MENU = List.of(WELCOME_MENU_FIRST, WELCOME_MENU_SECOND, WELCOME_MENU_THIRD, WELCOME_MENU_FOURTH, WELCOME_MENU_FIFTH);
    public static final String HYPHEN = "-";
    public static final Integer INT_ZERO = 0;
    public static final Integer INT_ONE = 1;
    public static final Integer INT_TEN = 10;

    private static final String EMAIL_REGEX = "^(.+)@(.+).(.+)$";
    public static final Pattern EMAIL_REGEX_PATTERN = Pattern.compile(EMAIL_REGEX);
}
