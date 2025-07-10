package lld.carrental.model;

import lombok.Data;

@Data
public class Bill {

    Reservation reservation;
    double totalBillAmount;
    boolean isBillPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalBillAmount = computeBillAmount();
        isBillPaid = false;
    }

    public double computeBillAmount(){
        return 500;
    }
}
