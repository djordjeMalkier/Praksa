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

    @PostMapping("/add")
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

    @GetMapping
    public ResponseEntity<UserDTO> getUserById(@RequestParam String id) {
        User user;
        try {
            user = userService.getUserByPersonalID(id);
            return ok(mapUser.userToUserDTO(user));
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
        } catch (EntityNotFoundException |
                 NullPointerException exception) {
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
                 EntityNotFoundException |
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
                 EntityNotFoundException |
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

    @DeleteMapping("/delete")
    public ResponseEntity<UserDTO> deleteUserById(@RequestParam String id) {
        User user;
        try {
            user = userService.deleteUserById(id);
            return ok(mapUser.userToUserDTO(user));
        } catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
    }

    @PostMapping("/addBankAccount")
    public ResponseEntity<BankAccountDTO> addBankAccount(@RequestBody BankAccountDTO bankAccountDTO) {
        BankAccount savedBankAccount;
        try {
            BankAccount bankAccount = mapBankAccount.convertToEntity(bankAccountDTO);
            savedBankAccount = userService.createBankAccount(bankAccount);
        } catch (EntityAlreadyExistsException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return ok(mapBankAccount.convertToDTO(savedBankAccount));
    }

    @DeleteMapping("/{personal_id}/accounts/{bankAccountID}/delete")
    public ResponseEntity<BankAccountDTO> deleteAccount(
            @PathVariable String personal_id,
            @PathVariable Integer bankAccountID
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

    @DeleteMapping("/{personal_id}/accounts/delete")
    public ResponseEntity<List<BankAccountDTO>> deleteAllAccounts(@PathVariable String personal_id) {
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

    @GetMapping("/{personal_id}/accounts")
    public ResponseEntity<List<BankAccountDTO>> getAllAccounts(@PathVariable String personal_id) {
        User user = null;
        try{
            user = userService.getUserByPersonalID(personal_id);
            return ok(mapBankAccount.bankAccountsToDTO(user.getBankAccounts()));
        } catch (NullPointerException exception) {
            return notFound().build();
        }
    }

    @GetMapping("{personal_id}/accounts/{account_id}")
    public ResponseEntity<BankAccountDTO> getAccount(
            @PathVariable String personal_id,
            @PathVariable Integer account_id
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
