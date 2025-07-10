package lld.bookmyshow.controller;

import lld.bookmyshow.service.Theater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TheaterController {

    private HashMap<String, List<Theater>> cityVsTheaters ;

    public TheaterController() {
        this.cityVsTheaters = new HashMap<>();
    }

    public void addTheater (String city, Theater theater){
        cityVsTheaters.computeIfAbsent(city, (k)-> new ArrayList<>()).add(theater);
    }

    public List<Theater> listAllTheater(String city){
        return cityVsTheaters.getOrDefault(city, new ArrayList<>());
    }
}
