package lld.bookmyshow.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Movie {
    String id;
    String name;
    String des;
    int duration;
    List<String> cast;
    LocalDate releasedOn;

    public Movie(String id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }
}
