package common.bankarskiSistem.controller;


import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.controller.dto.BankAccountDTO;
import common.bankarskiSistem.controller.dto.BankAccountMapper;
import common.bankarskiSistem.controller.dto.UserDTO;
import common.bankarskiSistem.controller.dto.UserMapper;
import common.bankarskiSistem.model.BankAccount;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/users", method = RequestMethod.GET)
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(BankarskiSistem.class);
    @Autowired
    private UserService userService;

    private final UserMapper mapper = UserMapper.INSTANCE;
    private final BankAccountMapper bankAccountMapper = BankAccountMapper.INSTANCE;


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

    @PostMapping("/{personal_id}/accounts/{bankAccountID}/delete")
    public ResponseEntity<BankAccountDTO> deleteAccount(
            @PathVariable String personal_id,
            @PathVariable String bankAccountID
    ) {
        BankAccount bankAccount = null;
        try {
            bankAccount = userService.getBankAccountByID(personal_id, Integer.getInteger(bankAccountID));
            User user = bankAccount.getUser();
            userService.deleteAccount(user.getPersonalId(), bankAccount);

        } catch (NullPointerException exception) {
            return badRequest().build();
        }
        return ok(bankAccountMapper.convertToDTO(bankAccount));
    }

    @PostMapping("/{personal_id}/accounts/delete")
    public ResponseEntity<UserDTO> deleteAllAccounts(@PathVariable String personal_id) {
        User user = null;
        try {
            user = userService.getUserByPersonalID(personal_id);
            userService.deleteAllAccounts(user.getPersonalId());

        } catch (NullPointerException exception) {
            return badRequest().build();
        }
        return ok(mapper.userToUserDTO(user));
    }

    @GetMapping("/{personal_id}/accounts")
    public ResponseEntity<List<BankAccountDTO>> getAllAccounts(@PathVariable String personal_id) {
        User user = null;
        try{
            user = userService.getUserByPersonalID(personal_id);
            log.info(user.toString());
            return ok(bankAccountMapper.bankAccountsToDTO(user.getBankAccounts()));
        } catch (NullPointerException exception) {
            return notFound().build();
        }
    }

    @GetMapping("{personal_id}/accounts/{account_id}")
    public ResponseEntity<BankAccountDTO> getAccount(
            @PathVariable String personal_id,
            @PathVariable String account_id
    ) {
        User user = null;
        try{
            user = userService.getUserByPersonalID(personal_id);
            log.info(user.toString());

            List<BankAccount> bankAccounts = user.getBankAccounts();
            for(BankAccount account : bankAccounts){
                if (Objects.equals(account.getIdAccount(), Integer.getInteger(account_id)))
                    return ok(bankAccountMapper.convertToDTO(account));
            }
        } catch (NullPointerException exception) {
            return notFound().build();
        }
        return null;
    }

}
