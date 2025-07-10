package lld.carrental;

import lld.carrental.controller.CarRentalController;
import lld.carrental.model.*;
import lld.carrental.service.VehicleInventory;
import lld.carrental.service.impl.CarInventory;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        CarRentalController carRentalController = new CarRentalController();
        User user = new User("U1001", "Bhavana", "1334fdg");
        VehicleInventory carInventory = new CarInventory();
        Vehicle swift = new Vehicle("V1001", "Swift", VehicleType.FOUR_WELLER, "KA10WE1234" );
        Vehicle creta = new Vehicle("V1002", "Creta", VehicleType.FOUR_WELLER, "MH10WE1234" );
        carInventory.addVehicle(swift);
        carInventory.addVehicle(creta);

        HashMap<VehicleType, VehicleInventory> vehicleInventoryHashMap = new HashMap<>();
        vehicleInventoryHashMap.put(VehicleType.FOUR_WELLER, carInventory);

        Store store = new Store("S1001", "Rent AutoMobile", "Blr",vehicleInventoryHashMap);
        carRentalController.addStore("Blr",store);
        System.out.println("---------------------------");
        System.out.println("list car from store at Blr");
        System.out.println(carRentalController.storeList("Blr"));
        System.out.println("---------------------------");
        System.out.println("Reserve Vehicle V1002");
        Reservation reservation = store.reserveVehicle(user, creta, LocalDateTime.of(2025, Month.APRIL, 10,10,10), LocalDateTime.now());
        System.out.println(reservation);
        System.out.println("----------------------------");
        System.out.println(store.getReservationList());

        Bill bill = new Bill(reservation);
        System.out.println("Bill Amount "+ bill.getTotalBillAmount());
        Payment payment = new Payment();
        boolean flag = payment.payBill(bill);

        store.endTrip(reservation, flag);

        System.out.println(reservation);

    }

}
