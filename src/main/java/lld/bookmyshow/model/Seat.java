package lld.bookmyshow.model;

import lombok.Data;

@Data
public class Seat {
    int id;
    int row;
    SeatCategory seatCategory;


    public Seat(int id, int row, SeatCategory seatCategory) {
        this.id = id;
        this.row = row;
        this.seatCategory = seatCategory;
    }
}
