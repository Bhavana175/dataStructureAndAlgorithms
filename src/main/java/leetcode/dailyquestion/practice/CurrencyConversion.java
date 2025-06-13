package leetcode.dailyquestion.practice;

import java.util.*;

public class CurrencyConversion {

    public static void main(String[] args) {

        List<CurrencyExchangeRates> ratesList = new ArrayList<CurrencyExchangeRates>();
        ratesList.add(new CurrencyExchangeRates("EUR", "GBP", 0.90));
        ratesList.add(new CurrencyExchangeRates("EUR", "USD", 1.10));
        ratesList.add(new CurrencyExchangeRates("USD", "EUR", 0.90));
        ratesList.add(new CurrencyExchangeRates("USD", "GBP", 0.80));
        ratesList.add(new CurrencyExchangeRates("GBP", "EUR", 1.10));
        ratesList.add(new CurrencyExchangeRates("GBP", "USD", 1.20));

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
                // Use "GBP" funds above: fee=1% of 600.EUR=6.EUR, no conversion needed for fee
        );

        String exchangeFeeCurrency=  "EUR";
        double  currencyExchangeFeePerc= 1;
        // output total exchange fee : 13.0
        System.out.println( calculateExchangeFee(transactionsList, ratesList, exchangeFeeCurrency, currencyExchangeFeePerc));
    }

    private static double calculateExchangeFee(List<Transactions> transactionsList, List<CurrencyExchangeRates> ratesList,
                                                String exchangeFeeCurrency, double currencyExchangeFeePerc) {
        double feeSum =0.0;
        HashMap<String, Double> rateMap = new HashMap<>();
        HashMap<String, Double> balanceMap = new HashMap<>();

        for(CurrencyExchangeRates rateEntity: ratesList){
            String key = rateEntity.from+"-"+rateEntity.to;
            rateMap.put(key, rateEntity.exchangeRate);
        }

        for(Transactions currTx : transactionsList ){
            if(currTx.type.equals("PAYIN")){
                balanceMap.put(currTx.txCurrency, balanceMap.getOrDefault(currTx.txCurrency,0.0)+currTx.amount);
            }else{
                // in case of payout : check if amt available in same currency as tx curr, yes thn pay
                // check other curr with suff amt , pay exchng fee, cover fee into euro use rate
                if(balanceMap.containsKey(currTx.txCurrency) && currTx.amount< balanceMap.get(currTx.txCurrency)){
                    balanceMap.put(currTx.txCurrency, balanceMap.get(currTx.txCurrency)-currTx.amount);
                }else {
                    for(Map.Entry<String, Double> balEntity: balanceMap.entrySet()){
                        if(balEntity.getKey().equals(currTx.txCurrency)) continue;
                        // calculate conversion rate, add to amt to be paid and check
                        double conversionRate = rateMap.get(currTx.txCurrency+"-"+balEntity.getKey());
                        double amtToBePAid = currTx.amount*conversionRate;
                        if(amtToBePAid< balEntity.getValue()){
                            balanceMap.put(balEntity.getKey(), balEntity.getValue()-amtToBePAid);
                            //fee calculation
                            double feeApplicable = currTx.amount*(currencyExchangeFeePerc/(double) 100);
                            if(currTx.txCurrency.equals(exchangeFeeCurrency)){
                                feeSum+=feeApplicable;
                            }else {
                                double rateToExchFeeCurr = rateMap.get(currTx.txCurrency+"-"+exchangeFeeCurrency);
                                feeSum+=Math.ceil(feeApplicable*rateToExchFeeCurr);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return feeSum;
    }
}

class CurrencyExchangeRates {

    protected String from;
    protected String to;
    protected double exchangeRate;

    public CurrencyExchangeRates(String from, String to, double exchangeRate) {
        this.from = from;
        this.to = to;
        this.exchangeRate = exchangeRate;
    }
}

class Transactions {
    protected int id;
    protected String type; //PAYIN, PAYOUT
    protected double amount;
    protected String txCurrency;

    public Transactions(int id, String type, double amount, String txCurrency) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.txCurrency = txCurrency;
    }
}