package common.bankarskiSistem.controller;


import common.bankarskiSistem.controller.dto.UserDto;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

  /*@PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        User savedUser = null;
        try {
            User user = null; //modelM.map(userDto);
            savedUser = userService.saveUser(user);

        } catch (NullPointerException exception) {
            return badRequest().build();
        }
        //
        return ok(savedUser);
    }*/


}
