package common.bankarskiSistem.controller;


import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.controller.dto.BankAccountDTO;
import common.bankarskiSistem.controller.dto.BankAccountMapper;
import common.bankarskiSistem.controller.dto.UserDTO;
import common.bankarskiSistem.controller.dto.UserMapper;
import common.bankarskiSistem.exceptions.EntityAlreadyExistsException;
import common.bankarskiSistem.exceptions.EntityNotFoundException;
import common.bankarskiSistem.model.BankAccount;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @GetMapping(value = "/getAccountBalance")
    public ResponseEntity<String> getAccountBalance(@RequestParam String personalId,
                                      @RequestParam Integer idAccount,
                                      @RequestParam(required = false) Optional<Currency> currency) {
        try{
            double balance = userService.getBalance(personalId, idAccount, currency);
            String currencyName = currency.isPresent() ? currency.get().toString() : "";
            return ok(balance + " " + currencyName);
        } catch (EntityNotFoundException |
                 NullPointerException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @GetMapping(value = "/getAllBalance")
    public ResponseEntity<String> getAllBankAccountBalance(@RequestParam String personalId,
                                      @RequestParam(required = false) Optional<Currency> currency) {
        try{
            double balance = userService.getAllBalance(personalId, currency);
            String currencyName = currency.isPresent() ? currency.get().toString() : "EUR";
            return ok(balance + " " + currencyName);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PutMapping("/payIn")
    public ResponseEntity<Double> payInUserBankAccount(@RequestParam String personalId,
                                                       @RequestParam Integer idAccount,
                                                       @RequestParam Double payment) {
        try{
            double balance = userService.payIn(personalId, idAccount, payment);
            return ok(balance);
        } catch (NullPointerException |
                 ArithmeticException |
                 EntityNotFoundException |
                 IllegalArgumentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PutMapping("/payOut")
    public ResponseEntity<Double> payOutUserBankAccount(@RequestParam String personalId,
                                                       @RequestParam Integer idAccount,
                                                       @RequestParam Double payment) {
        try{
            double balance = userService.payOut(personalId, idAccount, payment);
            return ok(balance);
        } catch (NullPointerException |
                 ArithmeticException |
                 EntityNotFoundException |
                 IllegalArgumentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PutMapping("/transfer")
    public ResponseEntity<String> transferFromUserAccountToAnotherUserAccount(@RequestParam String personalId,
                                                        @RequestParam Integer idAccountFrom,
                                                        @RequestParam Integer idAccountTo,
                                                        @RequestParam Double payment) {
        try{
            double transferMoney = userService.transfer(personalId, idAccountFrom, idAccountTo, payment);
            return ok("Successful transfer of " + transferMoney);
        } catch (NullPointerException |
                 ArithmeticException |
                 EntityNotFoundException |
                 IllegalArgumentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exception.getMessage(), exception);
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
    public ResponseEntity<BankAccountDTO> addBankAccountForUser(@RequestBody BankAccountDTO bankAccountDTO) {
        BankAccount savedBankAccount;
        try {
            BankAccount bankAccount = mapBankAccount.convertToEntity(bankAccountDTO);
            savedBankAccount = userService.createBankAccount(bankAccount);
        } catch (EntityAlreadyExistsException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return ok(mapBankAccount.convertToDTO(savedBankAccount));
    }

    @DeleteMapping("/deleteAccount")
    public ResponseEntity<BankAccountDTO> deleteAccount(
            @RequestParam String personal_id,
            @RequestParam Integer bankAccountID
    ) {
        BankAccount bankAccount = null;
        BankAccount deletedBankAccount = null;
        try {
            deletedBankAccount = userService.deleteAccountById(personal_id, bankAccountID);

        } catch (NullPointerException exception) {

            return badRequest().build();
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ok(mapBankAccount.convertToDTO(deletedBankAccount));
    }

    @DeleteMapping("/deleteAccounts")
    public ResponseEntity<List<BankAccountDTO>> deleteAllAccounts(@RequestParam String personal_id) {
        User user = null;
        List<BankAccount> bankAccounts = new ArrayList<>();
        try {
            user = userService.getUserByPersonalID(personal_id);
            bankAccounts = user.getBankAccounts();

            if(!bankAccounts.isEmpty()){
                for (BankAccount bankAccount: bankAccounts){
                    userService.deleteAccountById(personal_id, bankAccount.getIdAccount());
                }
            }

        } catch (NullPointerException exception) {
            return badRequest().build();
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ok(mapBankAccount.bankAccountsToDTO(bankAccounts));
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<BankAccountDTO>> getAllAccounts(@RequestParam String personal_id) {
        User user = null;
        try{
            user = userService.getUserByPersonalID(personal_id);
            return ok(mapBankAccount.bankAccountsToDTO(user.getBankAccounts()));
        } catch (NullPointerException exception) {
            return notFound().build();
        }
    }

    @GetMapping("/getAccount")
    public ResponseEntity<BankAccountDTO> getAccount(
            @RequestParam String personal_id,
            @RequestParam Integer account_id
    ) {
        User user = null;
        try{
            user = userService.getUserByPersonalID(personal_id);
            log.info(user.toString());

            List<BankAccount> bankAccounts = user.getBankAccounts();
            for(BankAccount account : bankAccounts){
                if (account.getIdAccount().equals(account_id)) {
                    return ok(mapBankAccount.convertToDTO(account));
                }
            }
        } catch (NullPointerException exception) {
            return notFound().build();
        }
        return null;
    }

}
