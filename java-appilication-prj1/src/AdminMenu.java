import api.AdminResource;
import api.HotelResource;
import constant.Constant;
import enums.RoomTypeEnum;
import interfaces.IRoom;
import models.Customer;
import models.Room;
import utils.AskingYesNoQuestion;
import utils.ShowMenu;

import java.util.*;

import static constant.Constant.ASKING_YES_NO;

public class AdminMenu {
    public static void displayChoices(){
        String getOptions = ShowMenu.getOptions(Constant.ADMIN_MENU);
        System.out.println(getOptions);
    }

    public static boolean execute(Scanner scanner, Integer choice){
        boolean isContinue = true;
        switch (choice){
            case 1:{
                showAllCustomers();
                break;
            }
            case 2: {
                showAllRooms();
                break;
            }
            case 3: {
                showAllReservations();
                break;
            }
            case 4: {
                addARoom(scanner);
                break;
            }
            case 5: {
                testData();
                break;
            }
            case 6: {
                isContinue = false;
                break;
            }
            default: {
                System.out.println(Constant.CHOOSE_ADMIN_MENU_OPTION_MESSAGE);
            }
        }
        return isContinue;
    }

    private static void showAllCustomers(){
        Collection<Customer> customers = AdminResource.Instance().getAllCustomers();
        if(customers.isEmpty()) System.out.println("No customer now");
        customers.forEach(customer -> System.out.println(customer.toString()));
    }

    private static void showAllRooms(){
        Collection<IRoom> rooms = AdminResource.Instance().getAllRooms();
        if(rooms.isEmpty()) System.out.println("No room now");
        rooms.forEach(room -> System.out.println(room.toString()));
    }

    private static void showAllReservations(){
        AdminResource.Instance().displayAllReservations();
    }

    private static void addARoom(Scanner scanner){
        boolean isContinue = true;
        String roomNumber;
        int number;
        double roomPrice;
        String roomType;
        RoomTypeEnum roomTypeEnum = null;
        do{
            try{
                System.out.println("Please enter room number: ");
                number = scanner.nextInt();
                roomNumber = String.valueOf(number);
                IRoom room = HotelResource.Instance().getRoom(roomNumber);
                if(Objects.nonNull(room)){
                    System.out.println("The room has this room number already existed, please try again.");
                    if(!AskingYesNoQuestion.continueAction(scanner)){
                        isContinue = false;
                    }
                }else {
                    System.out.println("Please enter room price: ");
                    roomPrice = Double.parseDouble(scanner.next());
                    if(roomPrice < Constant.INT_ZERO){
                        throw new NumberFormatException("Price must be at least zero, Please try again.");
                    }
                    scanner.nextLine();
                    System.out.println("Please enter room type. 1 for single bed, 2 for double bed: ");
                    roomType = scanner.nextLine();
                    if(!roomType.isBlank()){
                        if(roomType.equalsIgnoreCase("1")) roomTypeEnum = RoomTypeEnum.SINGLE;
                        else if(roomType.equalsIgnoreCase("2")) roomTypeEnum = RoomTypeEnum.DOUBLE;
                        else{
                            System.out.println("You can only enter 1 or 2. Please try again.");
                        }
                    }
                    else{
                        System.out.println("You must choose your room type");
                    }
                    if(!roomNumber.isBlank() && !roomType.isBlank() && Objects.nonNull(roomTypeEnum)){
                        room = new Room(roomNumber, roomPrice, roomTypeEnum);
                        AdminResource.Instance().addRoom(room);
                        System.out.println("Room added successfully. Do you want to continue add a Room?" + ASKING_YES_NO);
                        String confirmation = scanner.nextLine();
                        isContinue =  AskingYesNoQuestion.askYesNoQuestion(confirmation);
                    }else {
                        System.out.println("One of your data is empty, please input full required field.");
                    }
                }
            }catch (NumberFormatException ex){
                System.out.println(Objects.nonNull(ex.getMessage()) ? ex.getMessage() :  "You can only enter number, please try again.");
                isContinue = false;
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                isContinue = false;
            }catch (InputMismatchException ex){
                System.out.println("Room number must be a number!");
                isContinue = false;
            }
        }while(isContinue);
    }

    private static void testData(){
        String roomNumber;
        double price = Constant.ZERO_PRICE;
        RoomTypeEnum roomType;
        for (int i = Constant.INT_ONE; i <= Constant.INT_THREE; i++) {
            roomNumber = Integer.toString(i);
            if (i % Constant.INT_TWO == Constant.INT_ZERO) {
                price = Constant.ONE_HUNDRED_PRICE;
                roomType = RoomTypeEnum.DOUBLE;
            } else {
                price = Constant.FIFTY_PRICE;
                roomType = RoomTypeEnum.SINGLE;
            }
            IRoom newRoom = new Room(roomNumber, price, roomType);
            AdminResource.Instance().addRoom(newRoom);
        }
        HotelResource.Instance().createCustomer("test1@mail.com", "Bui", "Hien");
        HotelResource.Instance().createCustomer("test2@mail.com", "Nguyen", "Anh");
        HotelResource.Instance().createCustomer("test3@mail.com", "Tran", "Long");
        HotelResource.Instance().createCustomer("test4@mail.com", "Pham", "Minh");
        HotelResource.Instance().createCustomer("test5@mail.com", "Nguyen", "Yen");
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        Date checkInDate;
        Date checkOutDate;
        calendar.setTime(today);
        calendar.add(Calendar.DATE, Constant.INT_THREE);
        checkInDate = calendar.getTime();
        calendar1.setTime(checkInDate);
        calendar1.add(Calendar.DATE, Constant.INT_SIX);
        checkOutDate = calendar1.getTime();
        HotelResource.Instance().bookARoom("test1@mail.com", HotelResource.Instance().getRoom(Constant.INT_ONE.toString()), checkInDate, checkOutDate);
        calendar.setTime(today);
        calendar.add(Calendar.DATE, Constant.INT_FIVE);
        checkInDate = calendar.getTime();
        calendar1.setTime(checkInDate);
        calendar1.add(Calendar.DATE, Constant.INT_ELEVEN);
        checkOutDate = calendar1.getTime();
        HotelResource.Instance().bookARoom("test3@mail.com", HotelResource.Instance().getRoom(Constant.INT_TWO.toString()), checkInDate, checkOutDate);
        calendar.setTime(today);
        calendar.add(Calendar.DATE, Constant.INT_SIX);
        checkInDate = calendar.getTime();
        calendar1.setTime(checkInDate);
        calendar1.add(Calendar.DATE, Constant.INT_FOUR);
        checkOutDate = calendar1.getTime();
        HotelResource.Instance().bookARoom("test4@mail.com", HotelResource.Instance().getRoom(Constant.INT_THREE.toString()), checkInDate, checkOutDate);
        System.out.println("Mock data successfully");
    }
}
