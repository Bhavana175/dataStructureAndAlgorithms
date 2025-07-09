package lld.splitwise.service;

import lld.splitwise.model.Balance;
import lld.splitwise.model.User;
import lombok.Data;

import java.util.HashMap;

@Data
public class UserBalanceSheet {

    HashMap<String, Balance> userVsBalanceHashMap = new HashMap<>();
    double totalYourExpense;
    double totalPayment;
    double totalYouOwe;
    double totalYouGetBack;
}
