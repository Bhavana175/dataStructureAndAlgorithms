package com.workspace.learning.coderPad.parking;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@AllArgsConstructor
public class ParkingOld {

    private final HashMap<String, Integer> map;

    private int parkingLot;

    public ParkingOld() {
        this.parkingLot = 20;
        this.map = new HashMap<>();
    }

    public HashMap<String, Integer> getMap() {
        return this.map;
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

    public int availableParkingLot() {
        return parkingLot;
    }

    public void parkVehicle(String vehicleType) {

        if (vehicleType.equalsIgnoreCase("motercycle") && availableParkingLot() >= 1) {
            map.put("motercycle", map.getOrDefault("motercycle", 0) + 1);
            parkingLot--;
        }

        if (vehicleType.equalsIgnoreCase("car") && availableParkingLot() >= 1) {
            map.put("car", map.getOrDefault("car", 0) + 1);
            parkingLot--;
        }

        if (vehicleType.equalsIgnoreCase("van") && availableParkingLot() >= 3) {
            map.put("van", map.getOrDefault("van", 0) + 1);
            parkingLot = parkingLot - 3;
        }

    }

    public void exitParking(String vehicleType) {

        if (vehicleType.equalsIgnoreCase("motercycle") && map.containsKey("motercycle") && map.get("motercycle") > 0) {
            map.put("motercycle", map.getOrDefault("motercycle", 0) - 1);
            parkingLot++;
        }

        if (vehicleType.equalsIgnoreCase("car") && map.containsKey("car") && map.get("car") > 0) {
            map.put("car", map.getOrDefault("car", 0) - 1);
            parkingLot++;
        }

        if (vehicleType.equalsIgnoreCase("van") && map.containsKey("van") && map.get("van") > 0) {
            map.put("van", map.getOrDefault("van", 0) - 1);
            parkingLot = parkingLot + 3;
        }
    }

    public int spotsTakenByVehicle(String vehicleType) {

        if (vehicleType.equalsIgnoreCase("motercycle")) {
            return map.getOrDefault("motercycle", 0);
        } else {
            if (vehicleType.equalsIgnoreCase("car")) {
                return map.getOrDefault("car", 0);
            } else {
                if (vehicleType.equalsIgnoreCase("van")) {
                    return map.getOrDefault("van", 0) * 3;
                } else {
                    return 0;
                }
            }
        }
    }
}
