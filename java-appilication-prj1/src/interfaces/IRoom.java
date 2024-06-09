package interfaces;

import enums.RoomTypeEnum;

public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomTypeEnum getRoomType();
    public Boolean isFree();
}
