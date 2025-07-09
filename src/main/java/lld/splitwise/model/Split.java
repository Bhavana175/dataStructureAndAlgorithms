package lld.splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Split {
    User user;
    double amountOwe;
}
