package leetcode.dailyquestion;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class PayInPayOut {


    HashMap<String, Double> balanceMap = new HashMap<>();
    HashMap<String, Double> rateListMap = new HashMap<>();

    public static void main(String[] args) {

        String exchangeFeeCurrency = "EUR";
        int currencyExchangeFeePerc = 1;

        List<CurrencyExchangeRate> exchangeRateList = Arrays.asList(
                new CurrencyExchangeRate("EUR", "GBP", 0.90),
                new CurrencyExchangeRate("EUR", "USD", 1.10),
                new CurrencyExchangeRate("USD", "EUR", 0.90),
                new CurrencyExchangeRate("USD", "GBP", 0.80),
                new CurrencyExchangeRate("GBP", "EUR", 1.10),
                new CurrencyExchangeRate("GBP", "USD", 1.20));


        List<Transactions> transactionsList = Arrays.asList(
                new Transactions(1, "PAYIN", 1000, "EUR"),
                new Transactions(2, "PAYIN", 1000, "USD"),
                new Transactions(3, "PAYOUT", 800, "EUR"),
                new Transactions(4, "PAYOUT", 636, "GBP"),
                // Use USD funds above: fee=1% of 636.GBP = 6.36 GBP * 1.10(GBP->"EUR") = 7."EUR"
                new Transactions(5, "PAYOUT", 600, "EUR"),
                // Fail: no funds in any currency suffices to pay the transaction above
                new Transactions(6, "PAYIN", 700, "GBP"),
                new Transactions(7, "PAYOUT", 600, "EUR")
                // Use GBP funds above: fee=1% of 600.EUR=6.EUR, no conversion needed for fee
        );

        PayInPayOut obj = new PayInPayOut();

        System.out.println(obj.calculateBalance(transactionsList, exchangeRateList, exchangeFeeCurrency, currencyExchangeFeePerc));

        obj.balanceMap.entrySet().forEach((entry)->
                        System.out.println(entry.getKey()+", "+entry.getValue())
                );

    }

    private double calculateBalance(List<Transactions> transactionsList, List<CurrencyExchangeRate> exchangeRateList,
                                    String exchangeFeeCurrency, int currencyExchangeFeePerc) {
        double totalFee = 0;
        for (CurrencyExchangeRate rateEntity : exchangeRateList) {
            rateListMap.put(rateEntity.from + "-" + rateEntity.to, rateEntity.rate);
        }

        for (int i = 0; i < transactionsList.size(); i++) {
            Transactions tx = transactionsList.get(i);
            if (tx.payType.equals("PAYIN")) {
                balanceMap.put(tx.currency, balanceMap.getOrDefault(tx.currency, 0.0) + tx.amount);
            } else {
                // check if we have sufficient amount to pay out in the same payOutCurrency
                // else use other curry to payout
                // calculate fee
                // check conversion to EUR and add all to total fee
                double amountToBePaid = tx.amount;
                String payOutCurrency = tx.currency;

                if (balanceMap.containsKey(payOutCurrency) && amountToBePaid <= balanceMap.get(payOutCurrency)) {
                    balanceMap.put(payOutCurrency, balanceMap.get(payOutCurrency) - amountToBePaid);
                } else {
                    for (Map.Entry<String, Double> balanceEntry : balanceMap.entrySet()) {
                        String key = balanceEntry.getKey();
                        if (payOutCurrency.equals(key))
                            continue;

                        double rate = rateListMap.get(payOutCurrency + "-" + key);
                        double newAmountToBePaid = amountToBePaid * (rate);

                        if (newAmountToBePaid < balanceEntry.getValue()) {
                            balanceMap.put(key, balanceEntry.getValue() - newAmountToBePaid);
                            double newFee = amountToBePaid * ((double) currencyExchangeFeePerc/100);
                            if (payOutCurrency.equals(exchangeFeeCurrency)) {
                                totalFee += newFee;
                            } else {
                                double reverseRate = rateListMap.get(payOutCurrency + "-" + exchangeFeeCurrency);
                                totalFee += newFee * reverseRate;
                            }
                            break;
                        }
                    }

                }
            }
        }

        return totalFee;
    }

    @Data
    @AllArgsConstructor
    static class Transactions {
        private int id;
        private String payType;
        private double amount;
        private String currency;
    }

    @Data
    @AllArgsConstructor
    static class CurrencyExchangeRate {
        private String from;
        private String to;
        private double rate;
    }


}

