package lld.carrental.model;

public class Car extends Vehicle{
    public Car(String id, String name, VehicleType vehicleType, String number, String model, String power, String engine, VehicleStatus vehicleStatus) {
        super(id, name, vehicleType, number, model, power, engine, vehicleStatus);
    }
}
