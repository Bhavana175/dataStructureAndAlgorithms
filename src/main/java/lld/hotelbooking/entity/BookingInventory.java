package lld.hotelbooking.entity;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingInventory {

    private String hotelId;
    private LocalDate date;
    private RoomType roomType;
    private int totalInventory;
    private int totalReserved;

    public BookingInventory(String hotelId, RoomType roomType, LocalDate date, int totalInventory, int totalReserved) {
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.date = date;
        this.totalInventory = totalInventory;
        this.totalReserved = totalReserved;
    }

}
