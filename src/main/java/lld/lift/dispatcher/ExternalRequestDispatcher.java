package lld.lift.dispatcher;

import lld.lift.entities.Direction;

public interface ExternalRequestDispatcher {

    void submitRequest(int floor, Direction dir);
}
