package lld.bookmyshow.controller;

import lld.bookmyshow.model.Seat;
import lld.bookmyshow.model.Show;
import lld.bookmyshow.model.User;
import lld.bookmyshow.model.Booking;

import java.util.HashMap;
import java.util.List;

public class BookingController {

    private HashMap<String, Booking> bookingMap;

    public BookingController() {
        this.bookingMap = new HashMap<>();
    }

    public Booking reserveSeat(Show show, User user, List<Seat> selectedSeats) {

        for (Seat selected : selectedSeats) {
            if (show.getBookedSeatIds().contains(selected)) {
                System.out.println("*****************************************************");
                System.out.println("Seat : "+ selected +" not available, please try again");
                System.out.println("*****************************************************");
                break;
            }
        }
        Booking booking = new Booking(user, show, selectedSeats);
        bookingMap.put(booking.getBookingId(), booking);
        return booking;
    }

    public Booking confirmBooking(Booking booking){
        booking.getShowInformation().addSeatToBookedSeat(booking.getSelectedSeats());
        booking.getPayment().payBill(booking.getPayment().getAmount());
        System.out.println("Booking Successful");
        return booking;
    }
}
