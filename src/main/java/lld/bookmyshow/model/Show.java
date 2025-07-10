package lld.bookmyshow.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Show {
    String showId;
    Movie movie;
    Screen screen;
    LocalDateTime startDateTime;
    int duration;
    List<Seat> bookedSeatIds;

    public Show(String showId, Movie movie, Screen screen, LocalDateTime startDateTime, int duration) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.bookedSeatIds = new ArrayList<>();
    }

    public void addSeatToBookedSeat(List<Seat> seatList){
        bookedSeatIds.addAll(seatList);
    }
}
