package com.workspace.learning.coderPad.oopsconcept_parking;

import com.workspace.learning.coderPad.oopsconcept_parking.repo.Parking;
import com.workspace.learning.coderPad.oopsconcept_parking.service.Car;
import com.workspace.learning.coderPad.oopsconcept_parking.service.Motorcycle;
import com.workspace.learning.coderPad.oopsconcept_parking.service.Van;
import com.workspace.learning.coderPad.oopsconcept_parking.service.Vehicle;

public class Main {
    public static void main(String[] args) {

        Parking p1 = new Parking();
        Vehicle car = new Car(p1);
        Vehicle van = new Van(p1);
        Vehicle motorcycle= new Motorcycle(p1);
        System.out.println(p1.availableParkingLot());
        car.parkVehicle();
        System.out.println(p1.availableParkingLot());
        van.parkVehicle();
        van.parkVehicle();
        motorcycle.exitParking();
        motorcycle.parkVehicle();
        System.out.println("p1.availableParkingLot() : " +p1.availableParkingLot());
        System.out.println("p1.totalParkingLot() : "+p1.totalParkingLot());
        System.out.println("p1.isParkingFull() : "+p1.isParkingFull());
        System.out.println("p1.isParkingEmpty() : "+p1.isParkingEmpty());
        System.out.println("Spots Taken By Van  : "+van.spotsTakenByVehicle());
        System.out.println("Spots Taken By Car  : "+car.spotsTakenByVehicle());
        System.out.println("Spots Taken By Motorcycle  : "+motorcycle.spotsTakenByVehicle());
        System.out.println();
        van.parkVehicle();
        van.parkVehicle();
        van.parkVehicle();
        van.parkVehicle();
        van.parkVehicle();
        System.out.println("p1.availableParkingLot() : " +p1.availableParkingLot());
        System.out.println("Spots Taken By Van  : "+van.spotsTakenByVehicle());
    }
}
