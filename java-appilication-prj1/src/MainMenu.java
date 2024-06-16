import api.AdminResource;
import api.HotelResource;
import constant.Constant;
import interfaces.IRoom;
import models.Customer;
import models.Reservation;
import utils.*;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
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
            case 3: {
                registerCustomerAccount(scanner);
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
        scanner = new Scanner(System.in);
        return isContinue;
    }

    private static void findAndReserveRoom(Scanner scanner){
        Collection<IRoom> getRooms = AdminResource.Instance().getAllRooms();
        if(getRooms.isEmpty()){
            System.out.println(NO_ROOM_MESSAGE);
        }else {
            Date checkInDate = getCheckInCheckOutDate(INPUT_CHECKIN_DATE_MESSAGE,scanner, new Date(), Constant.INVALID_CHECKIN_DATE_VALUE);
            Date checkOutDate = getCheckInCheckOutDate(INPUT_CHECKOUT_DATE_MESSAGE, scanner, checkInDate, Constant.INVALID_CHECKOUT_DATE_VALUE);
            Collection<IRoom> availableRooms = HotelResource.Instance().findRooms(checkInDate, checkOutDate);
            boolean confirmationBooking = false;
            if(availableRooms.isEmpty()){
                boolean isAvailable = false;
                try{
                    while(!isAvailable){
                        Date recommendCheckInDate = RecommendDate.plusSevenDays(checkInDate);
                        Date recommendCheckOutDate = RecommendDate.plusSevenDays(checkOutDate);
                        availableRooms = HotelResource.Instance().findRooms(recommendCheckInDate, checkOutDate);
                        if(!availableRooms.isEmpty()){
                            isAvailable = true;
                            System.out.println(MessageFormat.format("There are no free rooms from the day you are looking for {0} - {1}. There are available check-in on date: {2} and check-out date: {3}", checkInDate, checkOutDate, recommendCheckInDate, recommendCheckOutDate));
                            checkInDate = DateValidation.dateFormatValidation(recommendCheckInDate.toString());
                            checkOutDate = DateValidation.dateFormatValidation(recommendCheckOutDate.toString());
                        }
                    }
                }catch (ParseException ex){
                    System.out.println(INVALID_COMMON_DATE_MESSAGE);
                }
            }else {
                System.out.println(MessageFormat.format("There are available check-in on date: {0} and check-out date: {1}", checkInDate, checkOutDate));
                confirmationBooking = AskBooking(scanner, availableRooms);
            }
            if(!confirmationBooking) {
                System.out.println("Thank you for coming our service");
            }else {
                Customer customer = checkCustomerInfo(scanner);
                if(Objects.isNull(customer)){
                    Customer newCustomer = registerCustomerAccount(scanner);
                    if(Objects.isNull(newCustomer)) {
                        System.out.println("Something went wrong while create new account, please try again");
                    }else {
                        bookARoom(scanner, availableRooms, newCustomer, checkInDate, checkOutDate);
                    }
                }
            }
        }
    }

    private static Date getCheckInCheckOutDate(String message, Scanner scanner, Date date, String errorMessage){
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

    private static boolean AskBooking(Scanner scanner, Collection<IRoom> rooms){
        for(IRoom room : rooms){
            System.out.println(room.toString());
        }
        System.out.println("Would you like to book a room?" + ASKING_YES_NO);
        String confirmation = scanner.next();
        return AskingYesNoQuestion.askYesNoQuestion(confirmation);
    }

    private static Customer registerCustomerAccount(Scanner scanner){
        boolean isContinue = true;
        boolean isEmailLegit = false;
        String email = null;
        String firstName = null;
        String lastName = null;
        do{
            System.out.println(ENTER_EMAIL_MESSAGE);
            email = scanner.next();
            Customer customer = HotelResource.Instance().getCustomerDetail(email);
            if(Objects.nonNull(customer)){
                System.out.println(INVALID_EMAIL_EXISTED);
                if(!AskingYesNoQuestion.continueAction(scanner)){
                    email = null;
                    isContinue = false;
                }
            }else {
                if(EmailValidation.isEmailValidFormat(email)){
                    isEmailLegit  = true;
                    isContinue = false;
                }else {
                    System.out.println(INVALID_EMAIL_FORMAT);
                }
            }
        }while(isContinue);
        if(!isEmailLegit) return null;
        else {
            isContinue = true;
            do{
                System.out.println(ENTER_FIRST_NAME_MESSAGE);
                firstName = scanner.next();
                System.out.println(ENTER_LAST_NAME_MESSAGE);
                lastName = scanner.next();
                if(firstName.isBlank() || lastName.isBlank()){
                    System.out.println("Your name is empty");
                    if(!AskingYesNoQuestion.continueAction(scanner)){
                        lastName = null;
                        firstName = null;
                        isContinue = false;
                    }
                }else {
                    isContinue = false;
                    HotelResource.Instance().createCustomer(email, firstName, lastName);
                }

            }while(isContinue);
        }
        if(Objects.nonNull(email) && Objects.nonNull(firstName)) return new Customer(email, firstName, lastName);
        return null;
    }

    private static Customer checkCustomerInfo(Scanner scanner){
        System.out.println(ENTER_EMAIL_MESSAGE);
        String email = scanner.next();
        return HotelResource.Instance().getCustomerDetail(email);
    }

    private static void bookARoom(Scanner scanner, Collection<IRoom> rooms, Customer customer, Date checkInDate, Date checkOutDate){
        IRoom room = null;
        boolean isDone = false;
        while (!isDone){
            System.out.println("Which room number do you want to reserve?: ");
            String roomNumber = scanner.next();
            room = HotelResource.Instance().getRoom(roomNumber);
            if(Objects.isNull(room)){
                System.out.println(INVALID_ROOM_NONEXISTED);
            }else {
                if(!rooms.contains(room)){
                    System.out.println("Your room is not available for now");
                }else {
                    isDone = true;
                }
            }
            if(!isDone) {
                boolean isContinued = AskingYesNoQuestion.continueAction(scanner);
                if(isContinued) {
                    isDone = true;
                    room = null;
                }
            }
        }
        if(Objects.nonNull(room)){
            Reservation reservation = HotelResource.Instance().bookARoom(customer.getEmail(), room, checkInDate, checkOutDate);
            System.out.println("Your room was booked successfully, thank you for using our services");
        }else {
            System.out.println("Your room was not booked successfully.");
        }
    }

}