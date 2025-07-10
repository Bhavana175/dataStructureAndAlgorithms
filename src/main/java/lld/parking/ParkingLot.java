package lld.parking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot implements Parking {

    HashMap<Integer, ParkingLevel> parkingLevelMap = new HashMap<>();

    HashMap<UUID, ParkingReceipt> parkedVehicleEntries = new HashMap<>();

    @Override
    public ParkingReceipt entryParking(String vehicleNumber, ParkingSpotType parkingSpotType) {

        if (!isParkingSpotAvailable(parkingSpotType)) {
            throw new IllegalArgumentException("Parking not available for " + parkingSpotType);
        }
        //generate receipt
        ParkingReceipt parkingReceipt = new ParkingReceipt(vehicleNumber, parkingSpotType);
        parkedVehicleEntries.put(parkingReceipt.id, parkingReceipt);

        //update parking level parking
        parkingReceipt.setLevel(updateParkingLevelForEntry(parkingReceipt));

        return parkingReceipt;
    }

    @Override
    public double exitParking(ParkingReceipt parkingReceipt) {

        if (parkedVehicleEntries.containsKey(parkingReceipt.id)) {
            double amount = calculateParkingFee(parkingReceipt.inTime, LocalDateTime.now(), parkingReceipt.type);
            parkedVehicleEntries.remove(parkingReceipt.id);

            //increment parking spot in parking
            updateParkingLevelForExit(parkingReceipt);
            return amount;
        }

        return 0;
    }

    @Override
    public double calculateParkingFee(LocalDateTime inTime, LocalDateTime outTime, ParkingSpotType parkingSpotType) {
        double amount = 5;
        switch (parkingSpotType) {
            case MEDIUM -> amount = 10;
            case LARGE -> amount = 15;
        }
        //outTime = outTime.plusMinutes(120); // add 2 hr for outTime
        Duration difference = Duration.between(inTime, outTime);
        int totalHour = (int) difference.toHours() + 1;
        return amount * totalHour;
    }

    @Override
    public boolean isParkingSpotAvailable(ParkingSpotType parkingSpotType) {
        for (Map.Entry<Integer, ParkingLevel> entry : parkingLevelMap.entrySet()
        ) {
            switch (parkingSpotType) {
                case SMALL -> {
                    if (entry.getValue().getSmallSpotCapacity() - entry.getValue().getSmallSpotOccupied() > 0) {
                        return true;
                    }
                }
                case MEDIUM -> {
                    if (entry.getValue().getMediumSpotCapacity() - entry.getValue().getMediumSpotOccupied() > 0) {
                        return true;
                    }
                }
                case LARGE -> {
                    if (entry.getValue().getLargeSpotCapacity() - entry.getValue().getLargeSpotOccupied() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean addParkingLevel(int level, ParkingLevel parkingLevel) {

        if (!parkingLevelMap.containsKey(level)) {
            parkingLevelMap.put(level, parkingLevel);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeParkingLevel(int level) {

        if (parkingLevelMap.containsKey(level)) {
            parkingLevelMap.remove(level);
            return true;
        }
        return false;
    }

    public void displayParking() {
        System.out.println();
        for (Map.Entry<Integer, ParkingLevel> entry : parkingLevelMap.entrySet()
        ) {
            System.out.println("level : "+ entry.getKey() );
            System.out.println("Spots : "+ entry.getValue() );
        }
        System.out.println();
        for (Map.Entry<UUID, ParkingReceipt> entry : parkedVehicleEntries.entrySet()
        ) {
            System.out.println("UUID  : "+entry.getKey());
            System.out.println("Receipt : "+entry.getValue());
        }
        System.out.println("--------------------------------------------------------------------");
    }

    private void updateParkingLevelForExit(ParkingReceipt parkingReceipt) {

        if (parkingLevelMap.containsKey(parkingReceipt.getLevel())) {

            switch (parkingReceipt.type) {
                case SMALL -> {
                    int smallSpotOccupied = parkingLevelMap.get(parkingReceipt.getLevel()).getSmallSpotOccupied();
                    if (smallSpotOccupied > 0) {
                        smallSpotOccupied--;
                        parkingLevelMap.get(parkingReceipt.getLevel()).setSmallSpotOccupied(smallSpotOccupied);
                    }
                }
                case MEDIUM -> {
                    int mediumSpotOccupied = parkingLevelMap.get(parkingReceipt.getLevel()).getMediumSpotOccupied();
                    if (mediumSpotOccupied > 0) {
                        mediumSpotOccupied--;
                        parkingLevelMap.get(parkingReceipt.getLevel()).setMediumSpotOccupied(mediumSpotOccupied);
                    }
                }
                case LARGE -> {
                    int largeSpotOccupied = parkingLevelMap.get(parkingReceipt.getLevel()).getLargeSpotOccupied();
                    if (largeSpotOccupied > 0) {
                        largeSpotOccupied--;
                        parkingLevelMap.get(parkingReceipt.getLevel()).setLargeSpotOccupied(largeSpotOccupied);
                    }
                }

            }

        }

    }

    private int updateParkingLevelForEntry(ParkingReceipt parkingReceipt) {

        for (Map.Entry<Integer, ParkingLevel> levelMap : parkingLevelMap.entrySet()
        ) {
            if (parkingReceipt.type == ParkingSpotType.SMALL &&
                    levelMap.getValue().getSmallSpotCapacity() - levelMap.getValue().getSmallSpotOccupied() > 0) {

                levelMap.getValue().setSmallSpotOccupied(levelMap.getValue().getSmallSpotOccupied() + 1);
                return levelMap.getKey();
            }
            if (parkingReceipt.type == ParkingSpotType.MEDIUM &&
                    levelMap.getValue().getMediumSpotCapacity() - levelMap.getValue().getMediumSpotOccupied() > 0) {

                levelMap.getValue().setMediumSpotOccupied(levelMap.getValue().getMediumSpotOccupied() + 1);
                return levelMap.getKey();
            }
            if (parkingReceipt.type == ParkingSpotType.LARGE &&
                    levelMap.getValue().getLargeSpotCapacity() - levelMap.getValue().getLargeSpotOccupied() > 0) {
                levelMap.getValue().setLargeSpotOccupied(levelMap.getValue().getLargeSpotOccupied() + 1);
                return levelMap.getKey();
            }

        }
        return 0;
    }
}
