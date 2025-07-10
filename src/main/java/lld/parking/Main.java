package lld.parking;

public class Main {

    public static void main(String[] args) {
        try {

            Parking p1 = new ParkingLot();

            ParkingLevel parkingLevel_0 = new ParkingLevel(4, 2, 3);
            p1.addParkingLevel(0, parkingLevel_0);

            ParkingLevel parkingLevel_1 = new ParkingLevel(5, 1, 2);
            p1.addParkingLevel(1, parkingLevel_1);

            ParkingLevel parkingLevel_2 = new ParkingLevel(0, 0, 2);
            p1.addParkingLevel(2, parkingLevel_2);

            p1.displayParking();

            ParkingReceipt v1 = p1.entryParking("MH14HY0001", ParkingSpotType.SMALL);
            ParkingReceipt v2 = p1.entryParking("MH14HY0002", ParkingSpotType.MEDIUM);
            p1.displayParking();
            ParkingReceipt v3 = p1.entryParking("MH14HY0003", ParkingSpotType.MEDIUM);
            ParkingReceipt v4 = p1.entryParking("MH14HY0004", ParkingSpotType.MEDIUM);
           // ParkingReceipt parkingReceipt1 = p1.entryParking("MH14HY0006", ParkingSpotType.MEDIUM);
            p1.displayParking();

            ParkingReceipt v5 = p1.entryParking("MP44GH00005", ParkingSpotType.LARGE);

            p1.displayParking();
            p1.removeParkingLevel(2);
            System.out.println();

            double amount = p1.exitParking(v1);
            System.out.println("amount " + amount);

            p1.exitParking(v2);
            p1.exitParking(v3);
            p1.exitParking(v4);
            p1.exitParking(v5);

            p1.displayParking();

        } catch (Exception e) {
            System.out.println("******************************************");
            System.out.println("Exception " + e.getMessage());
            System.out.println("******************************************");
        }

    }

}
