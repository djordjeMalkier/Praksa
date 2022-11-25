package common.bankarskiSistem.controller;

import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.controller.dto.BankDto;
import common.bankarskiSistem.controller.dto.BankMapper;
import common.bankarskiSistem.controller.dto.UserDTO;
import common.bankarskiSistem.controller.dto.UserMapper;
import common.bankarskiSistem.exceptions.NameOfTheBankAlreadyExistException;
import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.model.User;
import common.bankarskiSistem.service.BankService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping(value="/bank")
@RequiredArgsConstructor
@RestController
public class BankController {

    private static final Logger log = LoggerFactory.getLogger(BankarskiSistem.class);

    @Autowired
    private final BankService bankService;

    private final BankMapper mapper = BankMapper.INSTANCE;

    private final UserMapper mapperUser=UserMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<BankDto> saveBank(@RequestBody BankDto bankDto) {
        Bank savedBank;
        try {
            savedBank = bankService.createBank(mapper.convertToEntity(bankDto));

        } catch (NullPointerException | NameOfTheBankAlreadyExistException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
        }
        //
        return ok(mapper.convertToDTO(savedBank));
    }

   @DeleteMapping("/delete/{idBank}")
    public ResponseEntity<BankDto> deleteBank(@PathVariable Integer idBank) {
        Bank bank;
        try{
            bank = bankService.findById(idBank);
            bankService.deleteBank(bank);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return ok(mapper.convertToDTO(bank));
    }

    @GetMapping("/get/{idBank}")
    public ResponseEntity<BankDto> getBankById(@PathVariable Integer idBank) {
        Bank bank;
        try{
            bank = bankService.findById(idBank);
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return ok(mapper.convertToDTO(bank));
    }

    @PutMapping("/putName/{idBank}")
    public ResponseEntity<BankDto> updateBankName(@PathVariable Integer idBank, @RequestBody BankDto updatedBank){
        Bank bank;
        try{
            bank = bankService.findById(idBank);
            bankService.updateBankName(updatedBank.getName(), bank);


        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }

        return ok(mapper.convertToDTO(bank));
    }

    @PutMapping("/putAddress/{idBank}")
    public ResponseEntity<BankDto> updateBankAddress(@PathVariable Integer idBank, @RequestBody BankDto updatedBank){
        Bank bank;
        try{
            bank = bankService.findById(idBank);
            bankService.updateBankAddress(updatedBank.getAddress(), bank);


        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }

        return ok(mapper.convertToDTO(bank));
    }

    /*@PostMapping("/postER")
    public ResponseEntity<BankDto> saveExchangeRates(@RequestBody BankDto bankDto) {
        ExchangeRates savedExchangeRates;
        ExchangeRates exchangeRates=bankDto.getExchangeRates();
        Bank bank=mapper.convertToEntity(bankDto);
        try {
            savedExchangeRates = bankService.createExchangeRates(exchangeRates);
            bank.setExchangeRates(savedExchangeRates);

        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        //
        return ok(mapper.convertToDTO(bank));
    }*/

    @GetMapping("/getAllUsers/{idBank}")
    public ResponseEntity<List<UserDTO>> getAllUsers(@PathVariable Integer idBank) {
        List<UserDTO> users=new ArrayList<>();
        try{
            for(User user: bankService.getAllUsers(bankService.findById(idBank))){
                users.add(mapperUser.userToUserDTO(user));
            }
        } catch (NullPointerException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        }
        return ok(users);
    }




}
