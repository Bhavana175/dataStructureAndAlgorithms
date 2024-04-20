package com.workspace.learning.coderPad.oopsconcept_parking.service;

import com.workspace.learning.coderPad.oopsconcept_parking.repo.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Van implements Vehicle {

    @Autowired
    private Parking parking;

    public Van(Parking parking) {
        this.parking = parking;
    }

    @Override
    public int spotsTakenByVehicle() {
        return parking.getValue(VehicleType.VAN)*3;
    }

    @Override
    public void exitParking() {
        try {
            parking.remove(VehicleType.VAN, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void parkVehicle() {
        try {
            parking.add(VehicleType.VAN, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
