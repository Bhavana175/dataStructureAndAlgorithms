package lld.bookmyshow.controller;

import lld.bookmyshow.model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieController {

    HashMap<String, List<Movie>> locationVsMovies;

    public MovieController() {
        this.locationVsMovies = new HashMap<>();
    }

    public void addMovie(String city, Movie movie) {
        locationVsMovies.computeIfAbsent(city, (k) -> new ArrayList<>()).add(movie);
    }

    public List<Movie> listOfMovies(String city) {
        return locationVsMovies.getOrDefault(city, new ArrayList<>());
    }

}
