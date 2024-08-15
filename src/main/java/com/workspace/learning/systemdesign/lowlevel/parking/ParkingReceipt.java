package com.workspace.learning.systemdesign.lowlevel.parking;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public class ParkingReceipt {

    UUID id;
    String vehicleNumber;
    ParkingSpotType type;
    LocalDateTime inTime;

    private int level;

    public ParkingReceipt( String vehicleNumber, ParkingSpotType type) {
        this.id = UUID.randomUUID();
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.inTime = LocalDateTime.now();
    }
}
