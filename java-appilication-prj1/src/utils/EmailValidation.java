package utils;

import constant.Constant;

public class EmailValidation {
    public static boolean isEmailValidFormat(String email){
        return Constant.EMAIL_REGEX_PATTERN.matcher(email).matches();
    }
}
