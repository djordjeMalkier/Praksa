package common.bankarskiSistem.controller;


import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.controller.dto.UserDTO;
import common.bankarskiSistem.controller.dto.UserMapper;
import common.bankarskiSistem.model.Currency;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

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
            return ok(mapper.userToUserDTO(user));
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @GetMapping(value = {"/getAccountBalance/{personalId}/{idAccount}",
            "/getAccountBalance/{personalId}/{idAccount}/{currency}"})
    public ResponseEntity<String> getAccountBalance(@PathVariable String personalId,
                                      @PathVariable Integer idAccount,
                                      @PathVariable(required = false) Optional<Currency> currency) {
        try{
            double balance = userService.getBalance(personalId, idAccount, currency);
            String currencyName = currency.isPresent() ? currency.get().toString() : "";
            return ok(balance + " " + currencyName);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @GetMapping(value = {"/getAllBankAccountBalance/{personalId}",
            "/getAllBankAccountBalance/{personalId}/{currency}"})
    public ResponseEntity<String> getAllBankAccountBalance(@PathVariable String personalId,
                                      @PathVariable(required = false) Optional<Currency> currency) {
        try{
            double balance = userService.getAllBalance(personalId, currency);
            String currencyName = currency.isPresent() ? currency.get().toString() : "EUR";
            return ok(balance + " " + currencyName);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PutMapping("/payIn/{personalId}/{idAccount}/{payment}")
    public ResponseEntity<Double> payInUserBankAccount(@PathVariable String personalId,
                                                       @PathVariable Integer idAccount,
                                                       @PathVariable Double payment) {
        try{
            double balance = userService.payIn(personalId, idAccount, payment);
            return ok(balance);
        } catch (NullPointerException |
                 ArithmeticException |
                 IllegalArgumentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PutMapping("/payOut/{personalId}/{idAccount}/{payment}")
    public ResponseEntity<Double> payOutUserBankAccount(@PathVariable String personalId,
                                                       @PathVariable Integer idAccount,
                                                       @PathVariable Double payment) {
        try{
            double balance = userService.payOut(personalId, idAccount, payment);
            return ok(balance);
        } catch (NullPointerException |
                 ArithmeticException |
                 IllegalArgumentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PutMapping("/transfer/{personalId}/{idAccountFrom}/{idAccountTo}/{payment}")
    public ResponseEntity<String> transferFromUserAccountToAnotherUserAccount(@PathVariable String personalId,
                                                        @PathVariable Integer idAccountFrom,
                                                        @PathVariable Integer idAccountTo,
                                                        @PathVariable Double payment) {
        try{
            double transferMoney = userService.transfer(personalId, idAccountFrom, idAccountTo, payment);
            return ok("Successful transfer of " + transferMoney);
        } catch (NullPointerException |
                 ArithmeticException |
                 IllegalArgumentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
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
