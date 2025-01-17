package lld.hotelbooking.entity;

import lombok.Data;
import java.util.List;

@Data
public class Hotel {
    private String hotelId;
    private String name;
    private String rating;
    private List<Room> rooms;
    private Location location;
}
