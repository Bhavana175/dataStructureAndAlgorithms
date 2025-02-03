package lld.hotelbooking.repository;

import lld.hotelbooking.entity.Hotel;
import lld.hotelbooking.entity.Location;
import lld.hotelbooking.entity.Room;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class RoomRepository {

    public HashMap<String, Room> roomHashMap;

    public RoomRepository() {
        this.roomHashMap = new HashMap<>();
    }

    public Optional<Room> findRoomById(String roomId){
        return Optional.ofNullable(roomHashMap.get(roomId));
    }

    public List<Room> findAllRoomByHotelIdAndCheckInCheckOutDate(String hotelId, LocalDate checkInDate, LocalDate checkOutDate){
        List<Room> roomList = new ArrayList<>();

        return roomList;
    }

    public void save(Room room){
        roomHashMap.put(room.getRoomNo(), room);
    }

    public void deleteRoom(String roomNo){
        roomHashMap.remove(roomNo);
    }


}
