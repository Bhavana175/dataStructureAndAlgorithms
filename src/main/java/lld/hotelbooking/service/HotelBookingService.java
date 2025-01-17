package lld.hotelbooking.service;

import lld.hotelbooking.entity.BookingDetails;
import lld.hotelbooking.entity.Hotel;
import lld.hotelbooking.entity.Location;
import lld.hotelbooking.entity.RoomType;

import java.time.LocalDate;
import java.util.List;

public interface HotelBookingService {

    List<Hotel> searchHotel(String userId, Location location, LocalDate checkInDate, LocalDate checkOutDate);

    BookingDetails selectHotel(String userId, String hotelId, RoomType roomType, Location location, LocalDate checkInDate, LocalDate checkOutDate);

    String bookHotel(String userId, String hotelId, BookingDetails bookingDetails);
}
