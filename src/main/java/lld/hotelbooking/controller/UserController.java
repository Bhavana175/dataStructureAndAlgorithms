package lld.hotelbooking.controller;

import jakarta.websocket.server.PathParam;
import lld.hotelbooking.entity.User;
import lld.hotelbooking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/login")
    public ResponseEntity<?> login(@RequestParam User user){
        userService.login(user);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{userId}/logout")
    public void logout( @PathParam("userId") String userId ){
        userService.logout(userId);
    }

    @PostMapping("/{userId}/signup")
    public ResponseEntity<?> signup(@RequestParam User user){
        userService.signup(user);
        return  null;
    }

    @DeleteMapping("/{userId}")
    public void deleteUser( @PathParam("userId") String userId ){
        userService.deleteUser(userId);
    }

}
