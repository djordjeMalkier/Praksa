package common.bankarskiSistem.controller;


import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.controller.dto.BankAccountDTO;
import common.bankarskiSistem.controller.dto.BankAccountMapper;
import common.bankarskiSistem.controller.dto.UserDTO;
import common.bankarskiSistem.controller.dto.UserMapper;
import common.bankarskiSistem.exceptions.EntityAlreadyExistsException;
import common.bankarskiSistem.exceptions.EntityNotFoundException;
import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/users", method = RequestMethod.GET)
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(BankarskiSistem.class);
    @Autowired
    private UserService userService;

    private final UserMapper mapUser = UserMapper.INSTANCE;
    private final BankAccountMapper mapBankAccount = BankAccountMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDto) {
        User savedUser;
        try {
            User user = mapUser.userDTOtoUser(userDto);
            savedUser = userService.saveUser(user);

        } catch (EntityAlreadyExistsException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return ok(mapUser.userToUserDTO(savedUser));
    }

    @GetMapping("/get/{personalId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String personalId) {
        User user;
        try {
            user = userService.getUserByPersonalID(personalId);
            return ok(mapUser.userToUserDTO(user));
        } catch (NullPointerException exception) {
            return notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto) {
        User savedUser;
        try {

            User user = mapUser.userDTOtoUser(userDto);
            savedUser = userService.updateUser(user);

        } catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return ok(mapUser.userToUserDTO(savedUser));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDTO> deleteUserByPersonalId(@PathVariable String id) {
        User user;
        try {
            user = userService.deleteUserByPersonalId(id);
            return ok(mapUser.userToUserDTO(user));
        } catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PostMapping("/addBankAccountForUser")
    public ResponseEntity<BankAccountDTO> createBankAccountForUser(@RequestBody BankAccountDTO bankAccountDTO) {
        BankAccount savedBankAccount;
        try {

            BankAccount bankAccount = mapBankAccount.convertToEntity(bankAccountDTO);
            savedBankAccount = userService.createBankAccount(bankAccount);
        } catch (EntityAlreadyExistsException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return ok(mapBankAccount.convertToDTO(savedBankAccount));
    }
    /*
    TODO
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
