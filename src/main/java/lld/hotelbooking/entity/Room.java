package lld.hotelbooking.entity;


import lombok.Data;

@Data
public class Room {

    private String roomNo;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private String floor;
}
