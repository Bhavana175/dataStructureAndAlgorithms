package lld.bookmyshow.model;

import lld.bookmyshow.service.Payment;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Booking {

    private String bookingId;
    private User bookedByUser;
    private Show showInformation;
    private Payment payment;
    private List<Seat> selectedSeats;

    public Booking(User bookedByUser, Show showInformation, List<Seat> selectedSeats) {
        this.bookingId = UUID.randomUUID().toString();
        this.bookedByUser = bookedByUser;
        this.showInformation = showInformation;
        this.selectedSeats = selectedSeats;
        this.payment = new Payment(selectedSeats.size());
    }


}
