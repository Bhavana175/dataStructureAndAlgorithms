package lld.carrental.model;

import lld.carrental.service.VehicleInventory;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class Store {
    String storeId;
    String name;
    String location;
    HashMap<VehicleType, VehicleInventory> vehicleInventory;
    List<Reservation> reservationList;

    public Store(String storeId, String name, String location, HashMap<VehicleType, VehicleInventory> vehicleInventory) {
        this.storeId = storeId;
        this.name = name;
        this.location = location;
        this.vehicleInventory = vehicleInventory;
        this.reservationList = new ArrayList<>();
    }

    public List<Vehicle> listVehicleByType(VehicleType vehicleType){
        if(vehicleInventory.containsKey(vehicleType)){
            return vehicleInventory.get(vehicleType).getAvailableVehicle();
        }
        return new ArrayList<>();
    }

    public Reservation reserveVehicle(User user, Vehicle vehicle, LocalDateTime fromDateTime, LocalDateTime tillDateTime) {
        vehicle.setVehicleStatus(VehicleStatus.RESERVED);
        Reservation reservation = new Reservation("R1001", "outing", user, fromDateTime, tillDateTime, vehicle);
        reservationList.add(reservation);
        return reservation;
    }

    public void endTrip(Reservation reservation, boolean isBillPaid) {
        if (isBillPaid) {
            for (Reservation res : reservationList) {
                if (res.reservationId.equals(reservation.reservationId)) {
                    res.setReservationStatus(ReservationStatus.COMPLETED);
                    res.vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
                 //   return res;
                }
            }
        }
        System.out.println("Pay bill amount");
      //  return reservation;
    }

}
