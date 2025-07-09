package lld.splitwise.service;

import lld.splitwise.controller.ExpenseController;
import lld.splitwise.model.Expense;
import lld.splitwise.model.Split;
import lld.splitwise.model.SplitType;
import lld.splitwise.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group {

    String groupId;
    String name;
    List<User> groupMember;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group(String groupId, String name) {
        this.groupId = groupId;
        this.name = name;
        this.expenseList = new ArrayList<>();
        this.groupMember = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }

    public void addMember(User user) {
        groupMember.add(user);
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split> splitDetails, SplitType splitType, User paidByUser) {
        Expense expense = expenseController.createExpense(expenseId, description, paidByUser, expenseAmount, splitType, splitDetails);
        expenseList.add(expense);
        return expense;
    }
}
