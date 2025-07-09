package lld.splitwise.controller;

import lld.splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> userList;

    public UserController() {
        this.userList = new ArrayList<>();
    }

    public User getUser(String userId){
        for (User user: userList){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getUserList(){
        return userList;
    }

}
