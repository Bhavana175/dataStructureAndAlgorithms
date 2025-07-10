package lld.carrental.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    String id;
    String name;
    VehicleType vehicleType;
    String number;
    String model;
    String power;
    String engine;
    VehicleStatus vehicleStatus;

    public Vehicle(String id, String name, VehicleType vehicleType, String number) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.number = number;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }
}
