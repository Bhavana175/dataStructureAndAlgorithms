package lld.hotelbooking.service;

import lld.hotelbooking.entity.User;

public interface UserService {
    void login(User user);

    void logout(String userId);

    void signup(User user);

    void deleteUser(String userId);
}
