package lld.designpatterns.behavioral;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    /*
        The Observer Design Pattern is a behavioral design pattern that defines a one-to-many
        dependency between objects so that when one object (the subject) changes state,
        all its dependents (observers) are notified and updated automatically.

        how objects behave in response to changes in the state of other objects.
        components of observer design pattern
        1. Subject  [interface (register/deregister observer, list of observer, notify observer )]
        2. Observer  [interface ]
        3. ConcreteSubject
        4. ConcreteObserver

        example weather app, concreteObserver reacts to the changes of weather

     */
}


interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
interface Observer{
    void update(String weather);
}
@Component
class WeatherStation implements Subject{ // Concrete Subject

    List<Observer> observerList = new ArrayList<>();
    private String weather;

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach((o)->{
            o.update(weather);
        });
    }

    public void setWeather(String weather) {
        this.weather = weather;
        notifyObservers();
    }
}
@Component
class PhoneDisplay implements Observer{
    String weather;
    @Override
    public void update(String weather) {
        this.weather=weather;
        display();
    }

    public void display(){

        System.out.println("Phone Weather Notification "+ weather);
    }
}

class WeatherApp{

    public static void main(String[] args) {

        Observer phoneDisplay = new PhoneDisplay();

        WeatherStation weatherStation = new WeatherStation();
        weatherStation.addObserver(phoneDisplay);
        weatherStation.setWeather("Sunny");
        weatherStation.setWeather("Rainy");

    }

}
