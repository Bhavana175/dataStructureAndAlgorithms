package lld.hotelbooking.entity;

import java.time.LocalDate;

public class BookingDetails {

    private String bookingId;
    private String userId;
    private String hotelId;
    private RoomType roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfRooms;
    private double cost;
}
