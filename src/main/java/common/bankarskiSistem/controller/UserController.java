package common.bankarskiSistem.controller;

import common.bankarskiSistem.model.User;
import common.bankarskiSistem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = null;
        try {
            savedUser = userService.saveUser(user);

        } catch (NullPointerException exception) {
            return badRequest().build();
        }
        return ok(savedUser);
    }

}
