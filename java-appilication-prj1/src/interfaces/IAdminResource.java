package interfaces;

import models.Customer;

import java.util.Collection;
import java.util.List;

public interface IAdminResource {
    public Customer getCustomer(String email);
    public void addRoom(IRoom room);
    public Collection<IRoom> getAllRooms();
    public Collection<Customer> getAllCustomers();
    public void displayAllReservations();
}
