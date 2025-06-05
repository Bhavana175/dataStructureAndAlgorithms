package lld.lift.dispatcher;

import lld.lift.controller.ElevatorCarController;
import lld.lift.entities.Direction;
import lombok.NoArgsConstructor;


public class InternalRequestDispatcher {
    private final ElevatorCarController controller;

    public InternalRequestDispatcher(ElevatorCarController controller) {
        this.controller = controller;
    }

    public void submitRequest(int floor, Direction dir, int elevatorId){
        //using only one elevator for now
        controller.submitRequest(floor, dir);
        controller.controlElevator();
    }
}
