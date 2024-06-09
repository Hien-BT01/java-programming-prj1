package models;

import constant.Constant;
import enums.RoomTypeEnum;
import interfaces.IRoom;

public class Room implements IRoom {
    private String roomNumber;
    private Double price;
    private RoomTypeEnum roomTypeEnum;

    public Room(String roomNumber, Double price, RoomTypeEnum roomTypeEnum) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomTypeEnum = roomTypeEnum;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setRoomTypeEnum(RoomTypeEnum roomTypeEnum) {
        this.roomTypeEnum = roomTypeEnum;
    }

    public String toString() {
        return "Room number: " + this.roomNumber + " " + this.roomTypeEnum + " bed room Price: $" + this.price;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomTypeEnum getRoomType() {
        return this.roomTypeEnum;
    }

    @Override
    public Boolean isFree() {
        return this.price == (double) Constant.INT_ZERO;
    }
}
