package api;

import interfaces.IAdminResource;
import interfaces.IHotelResource;
import interfaces.IRoom;
import models.Customer;
import models.Reservation;
import services.CustomerService;
import services.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AdminResource implements IAdminResource {
    private static AdminResource instance = null;
    public static AdminResource Instance(){
        if(Objects.isNull(instance)){
            instance = new AdminResource();
        }
        return instance;
    }

    @Override
    public Customer getCustomer(String email) {
        return CustomerService.Instance().getCustomerDetail(email);
    }

    @Override
    public void addRoom(IRoom room) {
        ReservationService.Instance().addRoom(room);
    }

    @Override
    public Collection<IRoom> getAllRooms() {
        return ReservationService.Instance().getAllRooms();
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return CustomerService.Instance().getAllCustomers();
    }

    @Override
    public void displayAllReservations() {
        ReservationService.Instance().displayAllReservations();
    }
}
