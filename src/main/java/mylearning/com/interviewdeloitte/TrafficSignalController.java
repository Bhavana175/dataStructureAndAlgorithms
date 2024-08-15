package mylearning.com.interviewdeloitte;

public class TrafficSignalController {
    //Deloitte
    TrafficSignal trafficSignal;

    public TrafficSignalController(TrafficSignal trafficSignal) {
        this.trafficSignal = trafficSignal;
    }

    public void changeSignal(TrafficSignal trafficSignal) throws InterruptedException {

        switch(trafficSignal){
            case RED: this.trafficSignal = TrafficSignal.GREEN;
                Thread.sleep(4000);
                break;
            case GREEN:  this.trafficSignal = TrafficSignal.YELLOW;
                Thread.sleep(5000);
                break;
            case YELLOW: this.trafficSignal = TrafficSignal.RED;
                Thread.sleep(3000);
                break;
        }

    }

}

class Main{

    public static void main(String[] args) throws InterruptedException {

        TrafficSignalController controller = new TrafficSignalController(TrafficSignal.RED);

        while (true){
            System.out.println(controller.trafficSignal);
            controller.changeSignal(controller.trafficSignal);
        }

    }

}
