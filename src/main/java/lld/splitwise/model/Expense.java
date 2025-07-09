package lld.splitwise.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Expense {

    String expenseId;
    String description;
    User paidByUser;
    LocalDateTime dateTime;
    double totalAmount;
    SplitType splitType;
    List<Split> splitList;

    public Expense(String expenseId, String description, User paidByUser, double totalAmount,  SplitType splitType, List<Split> splitList) {
        this.expenseId = expenseId;
        this.description = description;
        this.paidByUser = paidByUser;
        this.totalAmount = totalAmount;
        this.dateTime = LocalDateTime.now();
        this.splitType = splitType;
        this.splitList = splitList;
    }
}
