package com.workspace.learning.systemdesign.lowlevel.parking;

import lombok.Data;

@Data
public class ParkingLevel {
    private int smallSpotCapacity;
    private int mediumSpotCapacity;
    private int largeSpotCapacity;
    private int smallSpotOccupied;
    private int mediumSpotOccupied;
    private int largeSpotOccupied;

    public ParkingLevel(int smallSpotCapacity, int mediumSpotCapacity, int largeSpotCapacity) {
        this.smallSpotCapacity = smallSpotCapacity;
        this.mediumSpotCapacity = mediumSpotCapacity;
        this.largeSpotCapacity = largeSpotCapacity;
    }

    @Override
    public String toString() {
        return "ParkingLevel{" +
                "smallSpotCapacity=" + smallSpotCapacity +
                ", mediumSpotCapacity=" + mediumSpotCapacity +
                ", largeSpotCapacity=" + largeSpotCapacity +
                ", smallSpotOccupied=" + smallSpotOccupied +
                ", mediumSpotOccupied=" + mediumSpotOccupied +
                ", largeSpotOccupied=" + largeSpotOccupied +
                '}';
    }
}
