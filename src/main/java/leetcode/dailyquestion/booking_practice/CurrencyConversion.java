package leetcode.dailyquestion.booking_practice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CurrencyConversion {
    public static HashMap<String, Double> rateListMap = new HashMap<>();


    public static void main(String[] args) {
        /*

        CurrencyConversion
        rate list
        "EUR", "GBP", 0.90;
        "EUR", "USD", 1.10;
        "USD", "EUR", 0.90;
        "USD", "GBP", 0.80;
        "GBP", "EUR", 1.10;
        "GBP", "USD", 1.20;

        Transactionlist
        (1, "PAYIN", 1000, "EUR"),
        (2, "PAYIN", 1000, "USD"),
        (3, "PAYOUT", 800, "EUR"),
        (4, "PAYOUT", 636, "GBP"),
        // Use USD funds above: fee=1% of 636.GBP = 6.36 GBP * 1.10(GBP->"EUR") = 7."EUR"
        (5, "PAYOUT", 600, "EUR"),
        // Fail: no funds in any currency suffices to pay the transaction above
        (6, "PAYIN", 700, "GBP"),
        (7, "PAYOUT", 600, "EUR")
        // Use "GBP" funds above: fee=1% of 600.EUR=6.EUR, no conversion needed for fee

        exchangeFeeCurrency=  "EUR";
        currencyExchangeFeePerc= 1;

        calculateExchangeFee for above

        // output total exchange fee : 13.0
         */

        rateListMap.put("EUR-GBP", 0.90);
        rateListMap.put("EUR-USD", 1.10);
        rateListMap.put("USD-EUR", 0.90);
        rateListMap.put("USD-GBP", 0.80);
        rateListMap.put("GBP-EUR", 1.10);
        rateListMap.put("GBP-USD", 1.20);

        List<Transaction> transactionList = new ArrayList<>();

        transactionList.add(new Transaction(1, "PAYIN", 1000, "EUR"));
        transactionList.add(new Transaction(2, "PAYIN", 1000, "USD"));
        transactionList.add(new Transaction(3, "PAYOUT", 800, "EUR"));
        transactionList.add(new Transaction(4, "PAYOUT", 636, "GBP"));
        transactionList.add(new Transaction(5, "PAYOUT", 600, "EUR"));
        transactionList.add(new Transaction(6, "PAYIN", 700, "GBP"));
        transactionList.add(new Transaction(7, "PAYOUT", 600, "EUR"));

        System.out.println(calculateExchangeFee(transactionList, "EUR", 1));

    }

    public static double calculateExchangeFee(List<Transaction> transactionList, String exchangeFeeCurrency, double currencyExchangeFeePerc) {

        HashMap<String, Double> balanceMap = new HashMap<>();
        double fee = 0.0;
        for (int i = 0; i < transactionList.size(); i++) {
            Transaction tx = transactionList.get(i);

            if (tx.type.equals("PAYIN")) {
                balanceMap.put(tx.getCurrency(),
                        balanceMap.getOrDefault(tx.getCurrency(), 0.0) + tx.amount);
            } else if (tx.type.equals("PAYOUT")) {
                boolean paid = false;
                if (balanceMap.containsKey(tx.getCurrency()) && balanceMap.get(tx.getCurrency()) >= tx.amount) {
                    balanceMap.put(tx.getCurrency(), balanceMap.get(tx.getCurrency()) - tx.amount);
                    paid = true;
                } else {
                    for (Map.Entry<String, Double> balAvailable : balanceMap.entrySet()) {

                        double availableAmount = balAvailable.getValue();
                        if (rateListMap.containsKey(tx.getCurrency() + "-" + balAvailable.getKey())) {
                            double amtNeeded = tx.amount * rateListMap.get(tx.getCurrency() + "-" + balAvailable.getKey());
                            if (amtNeeded <= availableAmount) {
                                balanceMap.put(balAvailable.getKey(), availableAmount - amtNeeded);
                                if (tx.getCurrency().equals(exchangeFeeCurrency)) {
                                    fee += (tx.amount * currencyExchangeFeePerc/100);
                                } else {
                                    fee += (tx.amount * (currencyExchangeFeePerc/100)) * rateListMap.get(tx.getCurrency() + "-" + exchangeFeeCurrency);
                                }
                                paid = true;
                                break;
                            }
                        }
                    }
                }
                if (!paid) {
                    System.out.println("Insufficient fund");
                }
            } else System.out.println("Invalid tx type");
        }
        return fee;
    }

    @Data
    @AllArgsConstructor
    static class Transaction {
        int id;
        String type;
        double amount;
        String currency;
    }

}
