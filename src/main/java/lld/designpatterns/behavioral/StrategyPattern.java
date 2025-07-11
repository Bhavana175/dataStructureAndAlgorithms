package lld.designpatterns.behavioral;

import lombok.Data;
import org.springframework.stereotype.Component;

public class StrategyPattern {
/*
 the Strategy pattern is a useful design pattern that allows the behavior of an object
  to be selected dynamically at runtime, providing flexibility, modularity, and testability.

  1. Client
  2. Context
  3. Strategy Interface
  4. Concrete Strategies


    example Sorting Strategy or Calling Strategy
 */
}

class Client{
    public static void main(String[] args) {

        CallStrategy callStrategy = new Jio();
        Mobile mobile = new Mobile(callStrategy);
        mobile.call();
        callStrategy.call();

    }
}
@Data
class Mobile{
    CallStrategy callStrategy;

    public Mobile(CallStrategy callStrategy) {
        super();
        this.callStrategy = callStrategy;
    }

    public void call(){
        callStrategy.call();
    }

}

interface CallStrategy{
    void call();
}
@Component
class Jio implements CallStrategy{

    @Override
    public void call() {
        System.out.println("calling from JIO sim");
    }
}
@Component
class Airtel implements CallStrategy{

    @Override
    public void call() {
        System.out.println("calling from AIRTEL sim");
    }
}
@Component
class Whatsapp implements CallStrategy{

    @Override
    public void call() {
        System.out.println("calling from Whatsapp");
    }
}
