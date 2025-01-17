package lld.hotelbooking.controller;

import lld.hotelbooking.dto.SearchRequest;
import lld.hotelbooking.entity.BookingDetails;
import lld.hotelbooking.entity.Hotel;
import lld.hotelbooking.entity.RoomType;
import lld.hotelbooking.service.HotelBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/bookings")
public class HotelBookingController {

    private final HotelBookingService hotelBookingService;

    public HotelBookingController(HotelBookingService hotelBookingService) {
        this.hotelBookingService = hotelBookingService;
    }

    @GetMapping("/user/{userId}/search")
    public ResponseEntity<?> searchHotel(@PathVariable("userId") String userId, @RequestBody SearchRequest searchRequest){
        List<Hotel> hotels = hotelBookingService.searchHotel(userId, searchRequest.getLocation(),
                searchRequest.getCheckInDate(), searchRequest.getCheckOutDate());
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PostMapping("/user/{userId}/hotels/{hotelId}")
    public ResponseEntity<?> selectHotel(@PathVariable ("userId") String userId,
                                         @PathVariable ("hotelId") String hotelId,
                                         @RequestParam (defaultValue = "STANDARD")  RoomType roomType,
                                         @RequestBody SearchRequest searchRequest){
        // Booking details with unique Id to eliminate multiple request with same user for same transaction
       BookingDetails bookingDetails = hotelBookingService.selectHotel(userId, hotelId, roomType,
                searchRequest.getLocation(), searchRequest.getCheckInDate(), searchRequest.getCheckOutDate());
        return new ResponseEntity<>(bookingDetails, HttpStatus.OK);
    }

    @PostMapping("/user/{userId}/hotels/{hotelId}")
    public ResponseEntity<?> bookHotel(@PathVariable ("userId") String userId,
                                       @PathVariable ("hotelId") String hotelId,
                                       @RequestBody BookingDetails bookingDetails){
        // successfully booking send notification
        String msg = hotelBookingService.bookHotel(userId, hotelId, bookingDetails);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
