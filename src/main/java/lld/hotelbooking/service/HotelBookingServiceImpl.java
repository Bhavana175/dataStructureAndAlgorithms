package lld.hotelbooking.service;

import lld.hotelbooking.entity.BookingDetails;
import lld.hotelbooking.entity.Hotel;
import lld.hotelbooking.entity.Location;
import lld.hotelbooking.entity.RoomType;

import java.time.LocalDate;
import java.util.List;

public class HotelBookingServiceImpl implements HotelBookingService{
    @Override
    public List<Hotel> searchHotel(String userId, Location location, LocalDate checkInDate, LocalDate checkOutDate) {
        return List.of();
    }

    @Override
    public BookingDetails selectHotel(String userId, String hotelId, RoomType roomType, Location location, LocalDate checkInDate, LocalDate checkOutDate) {
        return null;
    }

    @Override
    public String bookHotel(String userId, String hotelId, BookingDetails bookingDetails) {
        return "";
    }
}
