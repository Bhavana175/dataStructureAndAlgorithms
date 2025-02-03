package lld.hotelbooking.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private String userId;
    private String userName;
    private String password;
    private String email;

    public User(String userName, String password, String email) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.password = password;
        this.email = email;
    }


}
