package lld.hotelbooking.repository;

import lld.hotelbooking.entity.BookingDetails;

import java.util.HashMap;

public class BookingDetailsRepository {

    HashMap<String, BookingDetails> bookingDetailsHashMap;

    public BookingDetailsRepository() {
        this.bookingDetailsHashMap = new HashMap<>();
    }
}
