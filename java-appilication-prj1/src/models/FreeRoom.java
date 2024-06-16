package models;

import constant.Constant;
import enums.RoomTypeEnum;

public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, RoomTypeEnum enumeration) {
        super(roomNumber, (double) Constant.INT_ZERO, enumeration);
    }

    public String toString() {
        return "Room number: " + this.getRoomNumber() + " " + this.getRoomType() + " bed room Price: $0 (Free)";
    }
}
