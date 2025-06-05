package lld.lift.entities;

public class Door {
    public Door() {
    }
    void openDoor(boolean open){
      if(open) System.out.println("Open lift door");
    }
    void closeDoor(boolean close){
       if(close) System.out.println("Close lift door");
    }
}
