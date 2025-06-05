package lld.lift.controller;

import lld.lift.entities.Direction;
import lld.lift.entities.ElevatorCar;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ElevatorCarController {

    ElevatorCar elevatorCar;

    PriorityQueue<Integer> queueAsc = new PriorityQueue<>();
    PriorityQueue<Integer> queueDesc = new PriorityQueue<>((o1, o2) -> o2 - o1);
    List<Integer> requestListUpDir;
    List<Integer> requestListDownDir;

    public ElevatorCarController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        this.requestListUpDir = new ArrayList<>();
        this.requestListDownDir = new ArrayList<>();
    }


    public void submitRequest(int floor, Direction dir) {
        int currentFloor = elevatorCar.getCurrFloor().getNum();
        if (dir == Direction.UP) {
            if (elevatorCar.getDir() == dir && floor >= currentFloor) {
                queueAsc.add(floor);
            } else {
                requestListUpDir.add(floor);
            }
        } else {
            if (elevatorCar.getDir() == dir && floor <= currentFloor) {
                queueDesc.add(floor);
            } else {
                requestListDownDir.add(floor);
            }
        }
    }

    public void controlElevator() {

        while (true) {

            while (!queueAsc.isEmpty() && elevatorCar.getDir() == Direction.UP) {

                int currFloor = elevatorCar.getCurrFloor().getNum();
                System.out.println("curr floor " + currFloor);
                int desFloor = queueAsc.poll();

                if (currFloor > desFloor) {
                    elevatorCar.move(desFloor, Direction.DOWN);
                    elevatorCar.stop(desFloor);
                }

                for (int i = currFloor; i <= desFloor; i++) {
                    elevatorCar.move(i, Direction.UP);
                    submitRequest(3, Direction.UP);
                    submitRequest(2, Direction.UP);
                    submitRequest(4, Direction.UP);
                    submitRequest(4, Direction.DOWN);
                    ElevatorCar.sleep();

                    if (queueAsc.contains(i)) {
                        elevatorCar.stop(i);
                        queueAsc.remove(i);
                    }
                }
                elevatorCar.stop(desFloor);
                elevatorCar.setDir(Direction.DOWN);
                queueAsc.addAll(requestListUpDir);
                queueDesc.addAll(requestListDownDir);
                requestListDownDir.clear();
                requestListUpDir.clear();
            }

            while (!queueDesc.isEmpty() && elevatorCar.getDir() == Direction.DOWN) {

                int currFloor = elevatorCar.getCurrFloor().getNum();
                int desFloor = queueDesc.poll();
                if (currFloor < desFloor) {
                    elevatorCar.move(desFloor, Direction.UP);
                    elevatorCar.stop(desFloor);
                }

                for (int i = currFloor; i >= desFloor; i--) {

                    elevatorCar.move(i, Direction.DOWN);
                    submitRequest(6, Direction.DOWN);
                    submitRequest(2, Direction.DOWN);
                    submitRequest(4, Direction.UP);
                    ElevatorCar.sleep();

                    if (queueDesc.contains(i)) {
                        elevatorCar.stop(i);
                        queueDesc.remove(i);
                    }
                }
                elevatorCar.stop(desFloor);
                elevatorCar.setDir(Direction.UP);
                queueAsc.addAll(requestListUpDir);
                queueDesc.addAll(requestListDownDir);
                requestListDownDir.clear();
                requestListUpDir.clear();
            }


        }

    }

}
