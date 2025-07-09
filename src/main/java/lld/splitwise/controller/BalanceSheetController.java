package lld.splitwise.controller;

import lld.splitwise.model.Balance;
import lld.splitwise.model.Split;
import lld.splitwise.model.User;
import lld.splitwise.service.UserBalanceSheet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void showBalanceSheetOfUser(User user) {

        UserBalanceSheet userBalanceSheet = user.getUserBalanceSheet();
        System.out.println("User " + user.getName());

        System.out.println("Total your expense " + userBalanceSheet.getTotalYourExpense());
        System.out.println("Total payment made " + userBalanceSheet.getTotalPayment());
        System.out.println("Total you owes " + userBalanceSheet.getTotalYouOwe());
        System.out.println("Total you getBack " + userBalanceSheet.getTotalYouGetBack());

        for (Map.Entry<String, Balance> entry : userBalanceSheet.getUserVsBalanceHashMap().entrySet()) {
            System.out.println("UserId " + entry.getKey() + " YouGetBack :" + entry.getValue().getGetBack() + " YouOwe :" + entry.getValue().getOwes());
        }

    }


    public void updateUserExpenseBalanceSheet(User expPaidByUser, List<Split> splitList, double totalExpense) {

        UserBalanceSheet paidByUserBalSheet = expPaidByUser.getUserBalanceSheet();
        // 1. update total payment done by user
        paidByUserBalSheet.setTotalPayment(paidByUserBalSheet.getTotalPayment() + totalExpense);

        for (Split split : splitList) {
            // all user split
            User friendOwes = split.getUser();
            UserBalanceSheet friendsBalSheet = friendOwes.getUserBalanceSheet();
            double splitAmountOwe = split.getAmountOwe();

            friendsBalSheet.setTotalYourExpense(friendsBalSheet.getTotalYourExpense() + splitAmountOwe);

            if (friendOwes == expPaidByUser) {
                friendsBalSheet.setTotalYouGetBack(friendsBalSheet.getTotalYouGetBack() + (totalExpense - splitAmountOwe));

                HashMap<String, Balance> paidByUserFriendVsBalMap = friendsBalSheet.getUserVsBalanceHashMap();

                for (Split splitPerUser : splitList) {
                    String friendsUserId = splitPerUser.getUser().getUserId();
                    if (!friendsUserId.equals(expPaidByUser.getUserId())) {
                        //update get back amount for each friends
                        Balance updatedBalance;
                        if (paidByUserFriendVsBalMap.containsKey(friendsUserId)) {
                            updatedBalance = paidByUserFriendVsBalMap.get(friendsUserId);
                        } else {
                            updatedBalance = new Balance(0.0, 0.0);
                        }
                        updatedBalance.setGetBack(updatedBalance.getGetBack() + splitAmountOwe);
                        if(updatedBalance.getGetBack()>=updatedBalance.getOwes()){
                            updatedBalance.setGetBack(updatedBalance.getGetBack()- updatedBalance.getOwes());
                            friendsBalSheet.setTotalYouOwe(friendsBalSheet.getTotalYouOwe()-updatedBalance.getOwes());
                            friendsBalSheet.setTotalYouGetBack(friendsBalSheet.getTotalYouGetBack()-updatedBalance.getOwes());
                            updatedBalance.setOwes(0.0);
                        }
                        paidByUserFriendVsBalMap.put(friendsUserId, updatedBalance);
                    }

                }
            } else {
                friendsBalSheet.setTotalYouOwe(friendsBalSheet.getTotalYouOwe() + splitAmountOwe);
                HashMap<String, Balance> userVsBalHashMap = friendsBalSheet.getUserVsBalanceHashMap();
                Balance updateBalance;
                if (userVsBalHashMap.containsKey(expPaidByUser.getUserId())) {
                    updateBalance = userVsBalHashMap.get(expPaidByUser.getUserId());
                } else {
                    updateBalance = new Balance(0.0, 0.0);
                }
                updateBalance.setOwes(updateBalance.getOwes() + splitAmountOwe);
                if(updateBalance.getGetBack()>=updateBalance.getOwes()){
                    updateBalance.setGetBack(updateBalance.getGetBack()- updateBalance.getOwes());
                    friendsBalSheet.setTotalYouOwe(friendsBalSheet.getTotalYouOwe()-updateBalance.getOwes());
                    friendsBalSheet.setTotalYouGetBack(friendsBalSheet.getTotalYouGetBack()-updateBalance.getOwes());
                    updateBalance.setOwes(0.0);
                }
                userVsBalHashMap.put(expPaidByUser.getUserId(), updateBalance);
            }

            /*
            what should we update in friends balance sheet ?
                1. update paidByUser balance ---> total payment already did,
                    expense + (splitAmountOwes)
                    totalGetBack + (totalExpense- splitAmountOwes)
                    update map with friends and amount getBack
               2. for friends :->
                    expense +splitAmount
                    totalOwes+ splitAmount
                    map paidByUser .owes+ splitAmount

               HashMap<String, Balance> userVsBalanceHashMap = new HashMap<>();
                double totalYourExpense;
                double totalPayment;
                double totalYouOwe;
                double totalYouGetBack;
             */

        }
    }
}