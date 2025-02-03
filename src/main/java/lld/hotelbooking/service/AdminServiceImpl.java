package lld.hotelbooking.service;

import lld.hotelbooking.entity.Hotel;
import lld.hotelbooking.entity.Room;
import lld.hotelbooking.repository.BookingInventoryRepository;
import lld.hotelbooking.repository.HotelRepository;
import lld.hotelbooking.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {

    private HotelRepository hotelRepository;
    private RoomRepository roomRepository;
    private BookingInventoryRepository bookingInventoryRepository;


    public AdminServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository,
                            BookingInventoryRepository bookingInventoryRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.bookingInventoryRepository = bookingInventoryRepository;
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotelId) {
        Optional<Hotel> hotelById = hotelRepository.findHotelById(hotelId);
        return hotelById.orElseThrow(() -> new RuntimeException("Hotel not found "));
    }

    @Override
    public void deleteHotel(String hotelId) {
        hotelRepository.deleteHotel(hotelId);
    }

    @Override
    public void addRoom(String hotelId, Room room) {
        hotelRepository.findHotelById(hotelId).ifPresentOrElse((hotel) -> {
            hotel.getRooms().add(room);
            roomRepository.save(room);
        }, () -> {
            throw new RuntimeException("Hotel not found ");
        });
    }

    @Override
    public Room getRoom(String hotelId, String roomNo) {

        Optional<Hotel> hotelById = hotelRepository.findHotelById(hotelId);

        List<Room> roomList = new ArrayList<>();

        if (hotelById.isPresent()) {
            roomList = hotelById.get().getRooms().stream().filter((room) -> room.getRoomNo().equals(roomNo)).toList();
        }
        if (!roomList.isEmpty()) {
            return roomList.get(0);
        } else {
            throw new RuntimeException("Room not found for hotel id ");
        }

    }

    @Override
    public void deleteRoom(String hotelId, String roomNo) {

        Optional<Hotel> hotelById = hotelRepository.findHotelById(hotelId);

        if (hotelById.isPresent()) {
            hotelById.get().getRooms().removeIf(room -> room.getRoomNo().equals(roomNo));
            roomRepository.deleteRoom(roomNo);
        }
    }
}
