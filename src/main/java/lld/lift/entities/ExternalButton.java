package lld.lift.entities;

import lld.lift.controller.ElevatorCarController;
import lld.lift.dispatcher.ExtReqDisMinSeekTimeImpl;
import lld.lift.dispatcher.ExternalRequestDispatcher;

public class ExternalButton {
    Floor floor;
    Direction dir;

    private ExternalRequestDispatcher externalRequestDispatcher;

    public ExternalButton(Floor floor, Direction dir, ElevatorCar elevatorCar) {
        this.floor = floor;
        this.dir = dir;
        this.externalRequestDispatcher = new ExtReqDisMinSeekTimeImpl(new ElevatorCarController(elevatorCar));
        externalRequestDispatcher.submitRequest(floor.num, dir);
    }

    public void submitRequest(int floor, Direction dir){
        externalRequestDispatcher.submitRequest(floor, dir);
    }
}
