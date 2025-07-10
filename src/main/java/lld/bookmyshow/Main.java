package lld.bookmyshow;

import lld.bookmyshow.controller.BookingController;
import lld.bookmyshow.controller.MovieController;
import lld.bookmyshow.controller.TheaterController;
import lld.bookmyshow.model.*;
import lld.bookmyshow.service.Theater;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // create Movie
        Movie AVENGERS = new Movie("M1001", "AVENGERS", 2);
        Movie BAHUBALLI = new Movie("M1002", "BAHUBALLI", 3);
        Movie ZNMD = new Movie("M1003", "ZNMD", 2);

        MovieController movieController = new MovieController();

        movieController.addMovie("Blr", AVENGERS);
        movieController.addMovie("Blr", BAHUBALLI);
        movieController.addMovie("Blr", ZNMD);
        movieController.addMovie("Delhi", AVENGERS);
        movieController.addMovie("Delhi", BAHUBALLI);

        Theater theater = new Theater("T1001", "INOX", "Blr");
        Theater theater2 = new Theater("T1001", "PVR", "Blr");

        Seat seat = new Seat(1,1, SeatCategory.SILVER);
        Seat seat2 = new Seat(2,1, SeatCategory.SILVER);
        Seat seat3 = new Seat(3,1, SeatCategory.SILVER);
        Seat seat4 = new Seat(4,2, SeatCategory.GOLD);
        Seat seat5 = new Seat(5,2, SeatCategory.GOLD);
        List<Seat> seatList = new ArrayList<>();
        List<Seat> seatList2 = new ArrayList<>();
        seatList.add(seat);
        seatList.add(seat2);
        seatList.add(seat3);
        seatList.add(seat4);
        seatList.add(seat5);
        Seat seat6 = new Seat(1,1, SeatCategory.SILVER);
        Seat seat7 = new Seat(2,1, SeatCategory.SILVER);
        seatList2.add(seat6);
        seatList2.add(seat7);

        Screen screen1 = new Screen(1, seatList);
        Screen screen2 = new Screen(2, seatList2);

        Show show = new Show("S1001", AVENGERS, screen1, LocalDateTime.now(), AVENGERS.getDuration());
        Show show2 = new Show("S1002", AVENGERS, screen2, LocalDateTime.of(2025, Month.JULY,15, 4, 0,0), AVENGERS.getDuration());
        theater.addShow(show);
        theater.addShow(show2);

        theater.addScreen(screen1);
        theater.addScreen(screen2);

        TheaterController theaterController = new TheaterController();
        theaterController.addTheater("Blr", theater);
        theaterController.addTheater("Blr", theater2);
        User user = new User("U1001", "Bhavana");

        System.out.println(movieController.listOfMovies("Blr"));
        for (Show show1: theater.getShowList()){
            System.out.println(show1);
        }

        BookingController bookingController = new BookingController();
        List<Seat> selected  = new ArrayList<>();
        selected.add(seat2);
        selected.add(seat3);
        Booking booking = bookingController.reserveSeat(show, user, selected);
        System.out.println(booking);
        System.out.println(bookingController.confirmBooking(booking));
        Booking booking2 = bookingController.reserveSeat(show, user, selected);

        System.out.println();
        for (Show show1: theater.getShowList()){
            System.out.println(show1);
        }
    }
}
