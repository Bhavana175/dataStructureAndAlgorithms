package lld.hotelbooking.service;

import lld.hotelbooking.entity.Hotel;
import lld.hotelbooking.entity.Room;

public interface AdminService {
    void addHotel(Hotel hotel);

    Hotel getHotel(String hotelId);

    void deleteHotel(String hotelId);

    void addRoom(String hotelId, Room room);

    Room getRoom(String hotelId, String roomNo);

    void deleteRoom(String hotelId, String roomNo);
}
