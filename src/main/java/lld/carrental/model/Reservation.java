package lld.carrental.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reservation {
    String reservationId;
    String desc;
    User reservedByUser;
    LocalDateTime resCreatedAt;
    LocalDateTime resFromDateTime;
    LocalDateTime resTillDateTime;
    ReservationStatus reservationStatus;
    Vehicle vehicle;

    public Reservation(String reservationId, String desc, User reservedByUser, LocalDateTime resFromDateTime, LocalDateTime resTillDateTime, Vehicle vehicle) {
        this.reservationId = reservationId;
        this.desc = desc;
        this.reservedByUser = reservedByUser;
        this.resCreatedAt = LocalDateTime.now();
        this.resFromDateTime = resFromDateTime;
        this.resTillDateTime = resTillDateTime;
        this.reservationStatus = ReservationStatus.SCHEDULED;
        this.vehicle = vehicle;
    }
}
