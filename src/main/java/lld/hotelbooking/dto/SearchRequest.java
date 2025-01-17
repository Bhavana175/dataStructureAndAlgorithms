package lld.hotelbooking.dto;

import lld.hotelbooking.entity.Location;
import lombok.Data;

import java.time.LocalDate;


@Data

public class SearchRequest {
    // location or city
    private Location location;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
