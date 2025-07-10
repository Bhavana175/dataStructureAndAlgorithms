package lld.carrental.service;

import lld.carrental.model.Vehicle;

import java.util.List;

public interface VehicleInventory {

    List<Vehicle> getAvailableVehicle();
    void addVehicle(Vehicle vehicle);
    void removeVehicle(String vehicleId);
}
