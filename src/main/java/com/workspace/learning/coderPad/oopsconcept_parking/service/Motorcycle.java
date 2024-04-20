package com.workspace.learning.coderPad.oopsconcept_parking.service;

import com.workspace.learning.coderPad.oopsconcept_parking.repo.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Motorcycle implements Vehicle {

    @Autowired
    private Parking parking;

    public Motorcycle(Parking parking) {
        this.parking = parking;
    }

    @Override
    public int spotsTakenByVehicle() {
        return parking.getValue(VehicleType.MOTORCYCLE);
    }

    @Override
    public void exitParking() {
        try {
            parking.remove(VehicleType.MOTORCYCLE, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void parkVehicle() {
        try {
            parking.add(VehicleType.MOTORCYCLE, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
