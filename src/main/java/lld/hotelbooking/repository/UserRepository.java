package lld.hotelbooking.repository;

import lld.hotelbooking.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {

    public HashMap<String, User> users ;

    public UserRepository() {
        this.users = new HashMap<>();
    }
}
