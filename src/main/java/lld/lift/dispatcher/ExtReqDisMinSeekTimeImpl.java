package lld.lift.dispatcher;

import lld.lift.controller.ElevatorCarController;
import lld.lift.entities.Direction;
import lld.lift.entities.ElevatorCar;

public class ExtReqDisMinSeekTimeImpl implements  ExternalRequestDispatcher{

    private ElevatorCarController elevatorCarController ;

    public ExtReqDisMinSeekTimeImpl(ElevatorCarController elevatorCarController) {
        this.elevatorCarController = elevatorCarController;
    }

    @Override
    public void submitRequest(int floor, Direction dir) {

    }
}
