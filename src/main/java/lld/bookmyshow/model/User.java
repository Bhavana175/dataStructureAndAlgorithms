package lld.bookmyshow.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private String userId;
    private String name;
    List<Booking> bookingHistory;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.bookingHistory = new ArrayList<>();
    }
}
