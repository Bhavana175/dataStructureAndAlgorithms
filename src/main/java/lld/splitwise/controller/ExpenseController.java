package lld.splitwise.controller;

import lld.splitwise.model.Expense;
import lld.splitwise.model.Split;
import lld.splitwise.model.SplitType;
import lld.splitwise.model.User;
import lld.splitwise.service.ExpenseSplit;
import lld.splitwise.service.SplitFactory;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, User paidByUser,
                                 double totalExpenseAmount, SplitType splitType, List<Split> splitDetails){

        ExpenseSplit expenseSplit = SplitFactory.getSplitType(splitType);
        expenseSplit.validateSplit(splitDetails, totalExpenseAmount);
        Expense expense = new Expense(expenseId,description,paidByUser,totalExpenseAmount, splitType, splitDetails);
        // update user expense balance
        balanceSheetController.updateUserExpenseBalanceSheet( paidByUser, splitDetails, totalExpenseAmount);
        return expense;
    }
}
