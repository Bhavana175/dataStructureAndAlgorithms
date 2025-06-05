package lld.lift.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ElevatorCar {
    int id;
    Display display;
    Floor currFloor;
    Status liftStatus;
    Direction dir;
    InternalButton internalButton;
    Door door;

    public ElevatorCar(int id, Display display, Floor currFloor, Status liftStatus, Direction dir, InternalButton internalButton, Door door) {
        this.id = id;
        this.display = display;
        this.currFloor = currFloor;
        this.liftStatus = liftStatus;
        this.dir = dir;
        this.internalButton = internalButton;
        this.door = door;
    }

    public void move(int desFloor, Direction dir) {
        this.liftStatus = Status.MOVING;
        this.currFloor.num = desFloor;
        System.out.println("Moving "+dir+ " :  "+desFloor);
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(int desFloor) {
        this.liftStatus = Status.IDEAL;
        this.currFloor.num = desFloor;
        System.out.println("Stopped at floor "+ desFloor);
        sleep();
       // door.closeDoor(true);
    }

}
