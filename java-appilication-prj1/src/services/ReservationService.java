package services;

import constant.Constant;
import enums.RoomTypeEnum;
import interfaces.IRoom;
import models.Customer;
import models.Reservation;
import utils.DateValidation;

import java.util.*;

public class ReservationService {
    private static Map<String, IRoom> rooms = null;
    private static ReservationService instance = null;
    private static Map<String, Collection<Reservation>> reservations = null;

    public static ReservationService Instance(){
        if(Objects.isNull(instance)){
            instance = new ReservationService();
            rooms = new HashMap<>();
            reservations = new HashMap<>();
        }
        return instance;
    }

    public Collection<IRoom> getAllRooms(){
        return rooms.values();
    }

    public void addRoom(IRoom room){
        if(rooms.containsKey(room.getRoomNumber())) throw new IllegalArgumentException(Constant.UNIQUE_ROOM_NUMBER_EXCEPTION);
        else rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId){
        if(Objects.isNull(roomId) || roomId.isBlank()) return null;
        return rooms.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        if(Objects.isNull((customer)) || Objects.isNull(room) || Objects.isNull(checkInDate) || Objects.isNull(checkOutDate)) {
            throw new IllegalArgumentException(Constant.NULL_VALUE_EXCEPTION);
        }
        if(DateValidation.isValidReservationDate(checkInDate, checkOutDate)){
            throw new IllegalArgumentException(Constant.INVALID_DATETIME_EXCEPTION);
        }
        if(isReservedRoom(room, checkInDate, checkOutDate)){
            return null;
        }
        boolean isFreeToBookRoom = true;
        Reservation reservation;
        Collection<Reservation> getCustomerReservations = getCustomerReservations(customer);
        if(Objects.isNull(getCustomerReservations)) getCustomerReservations = new ArrayList<>();
        if (!Objects.nonNull(reservations.get(customer.getEmail()))) {
            for (Reservation getReservation : getCustomerReservations) {
                if (getReservation.isReserved(checkInDate, checkOutDate)) {
                    if (RoomTypeEnum.SINGLE.equals(getReservation.getRoom().getRoomType()) && RoomTypeEnum.SINGLE.equals(room.getRoomType())) {
                        isFreeToBookRoom = false;
                        break;
                    }
                }
            }
            if (!isFreeToBookRoom) throw new IllegalArgumentException(Constant.INVALID_SINGLE_ROOM_EXCEPTION);
        }
        reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        getCustomerReservations.add(reservation);
        reservations.put(customer.getEmail(), getCustomerReservations);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> reservedRooms = getReservationRooms(checkInDate, checkOutDate);
        Collection<IRoom> availableRooms = new ArrayList<>();
        for (IRoom room : rooms.values()) {
            if (!reservedRooms.contains(room)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Collection<Reservation> getCustomerReservations(Customer customer) {
        if(Objects.isNull(customer)){
            throw new IllegalArgumentException(Constant.NULL_VALUE_EXCEPTION);
        }
        return reservations.get(customer.getEmail());
    }

    public void displayAllReservations (){
        Collection<Reservation> getReservations = getAllReservations();
        if(getReservations.isEmpty()){
            System.out.println(Constant.NO_RESERVATION_MESSAGE);
        }
        for (Reservation reservation: getReservations){
            System.out.println(reservation.toString());
        }
    }

    private Collection<IRoom> getReservationRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> getRooms = new ArrayList<>();
        for(Collection<Reservation> reservationRooms : reservations.values()){
            for(Reservation reservationRoom : reservationRooms){
                if(reservationRoom.isReserved(checkInDate, checkOutDate)){
                    getRooms.add(reservationRoom.getRoom());
                }
            }
        }
        return getRooms;
    }

    public Collection<Reservation> getAllReservations() {
        Collection<Reservation> allReservations = new ArrayList<>();
        for (Collection<Reservation> reservation : reservations.values()) {
            allReservations.addAll(reservation);
        }
        return allReservations;
    }

    private boolean isReservedRoom(IRoom room, Date checkInDate, Date checkOutDate){
        Collection<IRoom> rooms = getReservationRooms(checkInDate, checkOutDate);
        return rooms.contains(room);
    }
}
