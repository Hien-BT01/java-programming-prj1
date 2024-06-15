import api.HotelResource;
import constant.Constant;
import interfaces.IRoom;
import utils.DateValidation;
import utils.RecommendDate;
import utils.ShowMenu;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import static constant.Constant.*;

public class MainMenu {
    public static void displayChoices(){
        String getOptions = ShowMenu.getOptions(MAIN_MENU);
        System.out.println(getOptions);
    }

    public static boolean execute(Scanner scanner, Integer choice){
        boolean isContinue = true;
        switch (choice){
            case 1 : {
                findAndReserveRoom(scanner);
                break;
            }
            case 5: {
                isContinue = false;
                break;
            }
            default: {
                System.out.println(Constant.CHOOSE_MAIN_MENU_OPTION_MESSAGE);
            }
        }
        return isContinue;
    }

    private static void findAndReserveRoom(Scanner scanner){
        Date checkInDate = getCheckInCheckOutDate(Constant.INPUT_CHECKIN_DATE_MESSAGE, scanner, new Date(), Constant.INVALID_CHECKIN_DATE_VALUE);
        Date checkOutDate = getCheckInCheckOutDate(Constant.INPUT_CHECKOUT_DATE_MESSAGE,scanner, checkInDate, Constant.INVALID_CHECKOUT_DATE_VALUE);
        Collection<IRoom> availableRooms = HotelResource.Instance().findRooms(checkInDate, checkOutDate);
        if(availableRooms.isEmpty()){
            Date recommendCheckInDate = RecommendDate.plusSevenDays(checkInDate);
            Date recommendCheckOutDate = RecommendDate.plusSevenDays(checkOutDate);
            availableRooms = HotelResource.Instance().findRooms(recommendCheckInDate, checkOutDate);
        }
    }

    private static Date getCheckInCheckOutDate(String message ,Scanner scanner, Date date,String errorMessage){
        boolean isValidatedDate = false;
        Date returnedDate = null;
        while(!isValidatedDate){
            try{
                System.out.println(message);
                String dateFromInput = scanner.next();
                returnedDate = DateValidation.dateFormatValidation(dateFromInput);
                if(returnedDate.before(date)){
                    System.out.println(errorMessage);
                    continue;
                }
                isValidatedDate = true;
            }catch (ParseException ex){
                System.out.println(WRONG_DATE_FORMAT_MESSAGE);
            }
        }
        return returnedDate;
    }
}