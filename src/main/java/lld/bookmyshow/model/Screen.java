package lld.bookmyshow.model;

import lombok.Data;

import java.util.List;

@Data
public class Screen {

    private int screenId;
    private List<Seat> seatList;

    public Screen(int screenId, List<Seat> seatList) {
        this.screenId = screenId;
        this.seatList = seatList;
    }
}
