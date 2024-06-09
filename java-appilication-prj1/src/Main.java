import api.HotelResource;
import constant.Constant;
import enums.OrderEnum;
import utils.ShowMenu;

public class Main {
    public static void main(String[] args) {
        HotelResource.Instance().createCustomer("jeff@example.com", "Bui", "Hien");
        System.out.println(HotelResource.Instance().getCustomerDetail("jeff@example.com"));
        System.out.println(ShowMenu.getOptions(Constant.WELCOME_MENU));
    }
}