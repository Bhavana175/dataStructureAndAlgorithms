package com.workspace.learning.coderPad.oopsconcept_parking.repo;

import com.workspace.learning.coderPad.oopsconcept_parking.service.VehicleType;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Parking {

    private final HashMap<VehicleType, Integer> map;

    private int parkingLot;

    public Parking() {
        this.parkingLot = 20;
        this.map = new HashMap<>();
    }
    public int getValue(VehicleType vehicleType) {
        return this.map.getOrDefault(vehicleType, 0);
    }

    public void add(VehicleType vehicleType, int val) {
        if (availableParkingLot() >= val) {
            map.put(vehicleType, map.getOrDefault(vehicleType, 0) + 1);
            parkingLot = parkingLot - val;
        } else {
            throw new RuntimeException("Parking Not Available for Vehicle" + vehicleType);
        }
    }

    public void remove(VehicleType vehicleType, int val) {
        if (map.containsKey(vehicleType) && map.get(vehicleType) >= 1) {
            map.put(vehicleType, map.getOrDefault(vehicleType, 0) - 1);
            parkingLot = parkingLot + val;
        } else {
            throw new RuntimeException("Vehicle Not Found : " + vehicleType);
        }
    }
    public int availableParkingLot() {
        return parkingLot;
    }
    public int totalParkingLot() {
        return 20;
    }
    public boolean isParkingEmpty() {
        return parkingLot > 0;
    }
    public boolean isParkingFull() {
        return parkingLot == 0;
    }
}
