package common.bankarskiSistem.controller;


import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.controller.dto.UserDTO;
import common.bankarskiSistem.controller.dto.UserMapper;
import common.bankarskiSistem.controller.dto.UserMapperImpl;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/users", method = RequestMethod.GET)
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(BankarskiSistem.class);
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDto) {
        User savedUser = null;
        UserMapper mapper = new UserMapperImpl();
        try {
            User user = mapper.userDTOtoUser(userDto);
            savedUser = userService.saveUser(user);

        } catch (NullPointerException exception) {
            return badRequest().build();
        }
        return ok(mapper.usertoUserDTO(savedUser));
    }

    @GetMapping("/get/{personalId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String personalId) {
        UserMapper mapper = new UserMapperImpl();
        User user = null;
        try{
            user = userService.getUserByPersonalID(personalId);
        } catch (NullPointerException exception) {
            return notFound().build();
        }
         return new ResponseEntity<>(mapper.usertoUserDTO(userService.getUserByPersonalID(personalId)),
                 HttpStatus.OK);
    }


}
