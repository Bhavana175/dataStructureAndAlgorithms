package lld.parking;

import java.time.LocalDateTime;

/*

Question 1: Design a Parking Lot System
Problem Statement:

Design a parking lot system that can handle different types of vehicles
(e.g., motorcycle, car, truck) and provide features like parking, un-parking,
and calculating parking fees.

Requirements:

The parking lot should have multiple levels, each with a certain number of parking spots.
Each parking spot can be of different sizes (small, medium, large).
Motorcycles can park in any spot, cars can park in medium or large spots, and
trucks can only park in large spots.
The system should track the entry and exit times of each vehicle and
calculate parking fees based on the duration of the stay.
The system should support operations like adding/removing levels, spots, and checking available spots.
Considerations:

Define the classes and methods needed.
Discuss the data structures required to manage the parking lot efficiently.
Consider scalability and potential future enhancements.
 */
public interface Parking {

    ParkingReceipt entryParking(String vehicleNumber, ParkingSpotType parkingSpotType);
    double exitParking(ParkingReceipt parkingReceipt);
    double calculateParkingFee(LocalDateTime inTime, LocalDateTime outTime, ParkingSpotType parkingSpotType);
    boolean isParkingSpotAvailable(ParkingSpotType parkingSpotType);
    boolean addParkingLevel(int level, ParkingLevel parkingLevel);
    boolean removeParkingLevel(int level);

    void displayParking();


}
