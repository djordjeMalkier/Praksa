package common.bankarskiSistem.controller;


import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.controller.dto.UserDTO;
import common.bankarskiSistem.controller.dto.UserMapper;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/users", method = RequestMethod.GET)
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(BankarskiSistem.class);
    @Autowired
    private UserService userService;

    private final UserMapper mapper = UserMapper.INSTANCE;


    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDto) {
        User savedUser = null;
        try {
            User user = mapper.userDTOtoUser(userDto);
            savedUser = userService.saveUser(user);

        } catch (NullPointerException exception) {
            return badRequest().build();
        }
        return ok(mapper.userToUserDTO(savedUser));
    }

    @GetMapping("/get/{personalId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String personalId) {
        User user = null;
        try{
            user = userService.getUserByPersonalID(personalId);
            log.info(user.toString());
            return ok(mapper.userToUserDTO(user));
        } catch (NullPointerException exception) {
            return notFound().build();
        }
    }

    /*
    * updateUser
    * deleteUserByPersonalId
    * createBankAccountForUser
    *
    * payInUserBankAccount
    * payOutUserBankAccount
    * transferFromUserAccountToAnotherAccount
    * getAccountBalance
    * getAllBankAccountBalance
    *
    * deleteOneAccount
    * deleteAllAccount
    * getAllAccounts
    * getBankAccountById
    *
    * */


}
