package lld.lift.entities;

import lld.lift.controller.ElevatorCarController;
import lld.lift.dispatcher.InternalRequestDispatcher;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class InternalButton {

    private int id;
    private int elevatorCarId;
    private List<Floor> floors;
    private boolean openDoor;
    private boolean closeDoor;
    private boolean emergency ;
    private  Door door;
    private  InternalRequestDispatcher internalRequestDispatcher;


    public InternalButton(int id, int elevatorCarId, List<Floor> floors, ElevatorCar elevatorCar) {
        this.id = id;
        this.elevatorCarId = elevatorCarId;
        this.floors = floors;
        this.door = new Door();
        this.internalRequestDispatcher = new InternalRequestDispatcher(new ElevatorCarController(elevatorCar));
    }

    public void setOpenDoor(boolean openDoor) {
        this.openDoor = openDoor;
        door.openDoor(openDoor);
    }

    public void setCloseDoor(boolean closeDoor) {
        this.closeDoor = closeDoor;
        door.closeDoor(closeDoor);
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
        System.out.println("Emergency Notification to Admin and Security Guard");
    }

    public void submitRequest(int floor, Direction dir){
        internalRequestDispatcher.submitRequest(floor, dir, elevatorCarId);
    }
}
