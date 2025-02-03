package lld.hotelbooking.service;

import lld.hotelbooking.entity.*;
import lld.hotelbooking.repository.BookingDetailsRepository;
import lld.hotelbooking.repository.BookingInventoryRepository;
import lld.hotelbooking.repository.HotelRepository;
import lld.hotelbooking.repository.RoomRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotelBookingServiceImpl implements HotelBookingService{


    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final BookingDetailsRepository bookingDetailsRepository;
    private final BookingInventoryRepository bookingInventoryRepository;

    private HashMap<String, List<BookingInventory>> bookingInventoryListByHotelIdMap;

    public HotelBookingServiceImpl(HotelRepository hotelRepository, BookingDetailsRepository bookingDetailsRepository, RoomRepository roomRepository, BookingInventoryRepository bookingInventoryRepository) {
        this.hotelRepository = hotelRepository;
        this.bookingDetailsRepository = bookingDetailsRepository;
        this.roomRepository = roomRepository;
        this.bookingInventoryRepository = bookingInventoryRepository;
    }

    @Override
    public List<Hotel> searchHotel(String userId, Location location, LocalDate checkInDate, LocalDate checkOutDate) {

        List<Hotel> hotelList = new ArrayList<>();

        List<Hotel> hotelByLocation = hotelRepository.findAllHotelByLocation(location);

        for(Hotel hotel : hotelByLocation){
            //for one hotel you got inventory based on each day, now check for availability
            List<BookingInventory> inventoryListForCheckInOutDates = bookingInventoryListByHotelIdMap.get(hotel.getHotelId()).stream()
                    .filter((b) -> b.getDate().isAfter(checkInDate.minusDays(1))
                            && b.getDate().isBefore(checkOutDate)).toList();

          for(BookingInventory b : inventoryListForCheckInOutDates){

              if(b.getTotalInventory() - b.getTotalReserved()>0){
                  hotelList.add(hotel);
              }

          }
        }

        return hotelList;
    }

    @Override
    public BookingDetails selectHotel(String userId, String hotelId, RoomType roomType, Location location,
                                      LocalDate checkInDate, LocalDate checkOutDate) {

        //11464


        return null;
    }

    @Override
    public String bookHotel(String userId, String hotelId, BookingDetails bookingDetails) {
        return "";
    }
}
