package lld.splitwise.service;
import lld.splitwise.model.SplitType;

public class SplitFactory {

    public static ExpenseSplit getSplitType(SplitType splitType){
        switch (splitType){
            case UNEQUAL -> {
                return new UnEqualSplit();
            }
            case PERCENTAGE -> {
                return new PercentageSplit();
            }
            default -> {
                return new EqualSplit();
            }
        }
    }
}
