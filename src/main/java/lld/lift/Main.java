package lld.lift;

import lld.lift.entities.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Floor f1 = new Floor(1);
        Floor f2 = new Floor(2);
        Floor f3 = new Floor(3);
        Floor f4 = new Floor(4);
        Floor f5 = new Floor(5);
        Floor f6 = new Floor(6);

        List<Floor> floorList = Arrays.asList(f1, f2, f3, f4, f5, f6);
        Building building = new Building(floorList);
        Display display = new Display(f1, Direction.UP);
        InternalButton internalButton = new InternalButton();
        Door door = new Door();
        ElevatorCar elevatorCar = new ElevatorCar(111, display, f1, Status.IDEAL, Direction.UP, internalButton, door);
        InternalButton internalButton1 = new InternalButton(1, 111, floorList, elevatorCar);


        internalButton1.submitRequest(6, Direction.UP);

    }
}
