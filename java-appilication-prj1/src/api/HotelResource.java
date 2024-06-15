package api;

import interfaces.IHotelResource;
import interfaces.IRoom;
import models.Customer;
import models.Reservation;
import services.CustomerService;
import services.ReservationService;

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
        return ReservationService.Instance().getARoom(roomNumber);
    }

    @Override
    public Reservation bookARoom(String email, IRoom room, Date checkInDate, Date checkOutDate) {
        return ReservationService.Instance().reserveARoom(CustomerService.Instance().getCustomerDetail(email), room, checkInDate, checkOutDate);
    }

    @Override
    public Collection<Reservation> getCustomersReservations(String email) {
        return ReservationService.Instance().getCustomerReservations(CustomerService.Instance().getCustomerDetail(email));
    }

    @Override
    public Collection<IRoom> findRooms(Date checkIn, Date checkOut) {
        return ReservationService.Instance().findRooms(checkIn, checkOut);
    }

    @Override
    public Customer getCustomerDetail(String email) {
        return CustomerService.Instance().getCustomerDetail(email);
    }
}
