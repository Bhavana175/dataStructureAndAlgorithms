package lld.carrental.model;

public class Payment {

    public boolean payBill(Bill bill){
        bill.isBillPaid = true;
        return true;
    }
}
