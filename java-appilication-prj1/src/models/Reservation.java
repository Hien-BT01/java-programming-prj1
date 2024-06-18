package models;

import interfaces.IRoom;
import utils.DateValidation;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }

    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public IRoom getRoom() {
        return this.room;
    }

    public boolean isReserved(Date checkInDate, Date checkOutDate) {
        return checkInDate.before(this.checkOutDate) && checkOutDate.after(this.checkInDate);
    }

    @Override
    public String toString() {
        return "Reservation for " + this.customer.getEmail() +
                " with room number " + room.getRoomNumber() +
                ", Check-In on: " + DateValidation.formatDateString(this.checkInDate) +
                ", Check-Out on: " + DateValidation.formatDateString(this.checkOutDate);
    }
}
