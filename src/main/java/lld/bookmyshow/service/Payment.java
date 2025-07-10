package lld.bookmyshow.service;

import lombok.Data;

import java.util.UUID;

@Data
public class Payment {
    private String paymentId;
    int amount ;
    boolean paymentStatus;

    public Payment(int seatCount) {
        this.paymentId = UUID.randomUUID().toString();
        this.amount = seatCount*10;
        this.paymentStatus = false;
    }

    public void payBill(int amount){
        paymentStatus = true;
    }

}
