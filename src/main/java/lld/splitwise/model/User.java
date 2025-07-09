package lld.splitwise.model;

import lld.splitwise.service.UserBalanceSheet;
import lombok.Data;

@Data
public class User {

    String userId;
    String name;
    String email;
    UserBalanceSheet userBalanceSheet;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.userBalanceSheet = new UserBalanceSheet();
    }

}
