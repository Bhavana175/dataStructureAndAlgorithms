package lld.carrental.service.impl;

import lld.carrental.model.Vehicle;
import lld.carrental.service.VehicleInventory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CarInventory implements VehicleInventory {

    List<Vehicle> carList = new ArrayList<>();

    @Override
    public List<Vehicle> getAvailableVehicle() {
        return carList;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        carList.add(vehicle);
    }

    @Override
    public void removeVehicle(String vehicleId) {
        for(Vehicle car : carList){
            if(car.getId().equalsIgnoreCase(vehicleId)){
                carList.remove(car);
            }
        }
    }
}
