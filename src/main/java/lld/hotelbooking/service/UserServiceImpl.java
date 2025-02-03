package lld.hotelbooking.service;

import lld.hotelbooking.entity.User;
import lld.hotelbooking.repository.UserRepository;

public class UserServiceImpl implements UserService{

    private final  UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String login(User user) {
        if(userRepository.users.containsKey(user.getUserId())){
            return user.getUserId();
        }
        return "user not found ";
    }

    @Override
    public void logout(String userId) {
        System.out.println("logged out");
    }

    @Override
    public String signup(User user) {
        User userEntity = new User(user.getUserName(), user.getPassword(), user.getEmail());
        userRepository.users.put(userEntity.getUserId(), userEntity);
        return userEntity.getUserId();
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.users.remove(userId);
    }
}
