package lld.hotelbooking.controller;

import lld.hotelbooking.entity.Hotel;
import lld.hotelbooking.entity.Room;
import lld.hotelbooking.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/hotels")
    @ResponseStatus(HttpStatus.OK)
    public void addHotel(@RequestBody Hotel hotel) {
        adminService.addHotel(hotel);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId) {
        Hotel hotel = adminService.getHotel(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @DeleteMapping("hotels/{hotelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHotel(@PathVariable("hotelId") String hotelId) {
        adminService.deleteHotel(hotelId);
    }

    @PostMapping("/hotels/{hotelId}/rooms")
    @ResponseStatus(HttpStatus.OK)
    public void addRoom(@PathVariable("hotelId") String hotelId, @RequestBody Room room) {
        adminService.addRoom(hotelId, room);
    }

    @GetMapping("/hotels/{hotelId}/rooms/{roomNo}")
    public ResponseEntity<Room> getRoom(@PathVariable("hotelId") String hotelId, @PathVariable("roomNo") String roomNo) {
        Room room = adminService.getRoom(hotelId, roomNo);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @DeleteMapping("/hotels/{hotelId}/rooms/{roomNo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable("hotelId") String hotelId, @PathVariable("roomNo") String roomNo) {
        adminService.deleteRoom(hotelId, roomNo);
    }


}
