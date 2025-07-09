package lld.splitwise.service;

import lld.splitwise.model.Split;

import java.util.List;

public interface ExpenseSplit {
    void validateSplit(List<Split> splitList, double expenseAmount);
}
