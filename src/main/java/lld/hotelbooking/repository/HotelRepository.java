package lld.hotelbooking.repository;

import lld.hotelbooking.entity.Hotel;
import lld.hotelbooking.entity.Location;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HotelRepository {

    public HashMap<String, Hotel> hotelHashMap;

    public HotelRepository() {
        this.hotelHashMap = new HashMap<>();
    }

    public Optional<Hotel> findHotelById(String hotelId){
       return Optional.ofNullable(hotelHashMap.get(hotelId));
    }

    public List<Hotel> findAllHotelByLocation(Location location){
        List<Hotel> hotelList = new ArrayList<>();
        for(Map.Entry<String, Hotel> entry : hotelHashMap.entrySet()){
           if(entry.getValue().getLocation().equals(location)){
               hotelList.add(entry.getValue());
           }
        }
        return hotelList;
    }

    public void save(Hotel hotel){
        hotelHashMap.put(hotel.getHotelId(), hotel);
    }

    public void deleteHotel(String hotelId){
        hotelHashMap.remove(hotelId);
    }

}
