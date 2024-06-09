package api;

import interfaces.IHotelResource;
import interfaces.IRoom;
import models.Customer;
import models.Reservation;
import services.CustomerService;

import java.util.*;

public class HotelResource implements IHotelResource {
    private static HotelResource instance = null;
    public static HotelResource Instance(){
        if(Objects.isNull(instance)){
            instance = new HotelResource();
        }
        return instance;
    }

    @Override
    public void createCustomer(String email, String firstName, String lastName) {
        CustomerService.Instance().createCustomer(email, firstName, lastName);
    }

    @Override
    public IRoom getRoom(String roomNumber) {
        return null;
    }

    @Override
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate) {
        return null;
    }

    @Override
    public Collection<Reservation> getCustomersReservations(String email) {
        return List.of();
    }

    @Override
    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return List.of();
    }

    @Override
    public Customer getCustomerDetail(String email) {
        return CustomerService.Instance().getCustomerDetail(email);
    }
}
