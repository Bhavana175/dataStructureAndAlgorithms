package lld.hotelbooking.entity;

import lombok.Data;

@Data
public class Location {

    private String longitude;
    private String latitude;
    private int pin;
    private String address;

}
