package lld.hotelbooking.service;

import lld.hotelbooking.entity.User;

public interface UserService {
    String login(User user);

    void logout(String userId);

    String signup(User user);

    void deleteUser(String userId);
}
