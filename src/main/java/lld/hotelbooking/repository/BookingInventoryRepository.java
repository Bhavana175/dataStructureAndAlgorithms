package lld.hotelbooking.repository;

import lld.hotelbooking.entity.BookingInventory;

import java.util.HashMap;

public class BookingInventoryRepository {

    HashMap<String, BookingInventory> bookingInventoryMap;

    public BookingInventoryRepository() {
        this.bookingInventoryMap = new HashMap<>();
    }
}
