package interfaces;

import models.Customer;
import models.Reservation;

import java.util.Collection;
import java.util.Date;

public interface IHotelResource {
    public void createCustomer(String email, String firstName, String lastName);

    public IRoom getRoom (String roomNumber);

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate);

    public Collection<Reservation> getCustomersReservations(String email);

    public Collection<IRoom> findRooms(Date checkIn, Date checkOut);

    public Customer getCustomerDetail(String email);
}
