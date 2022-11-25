package common.bankarskiSistem.controller;

import common.bankarskiSistem.BankarskiSistem;
import common.bankarskiSistem.controller.dto.BankDto;
import common.bankarskiSistem.controller.dto.BankMapper;
import common.bankarskiSistem.exceptions.NameOfTheBankAlreadyExistException;
import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.service.BankService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RequestMapping(value="/bank")
@RequiredArgsConstructor
@RestController
public class BankController {

    private static final Logger log = LoggerFactory.getLogger(BankarskiSistem.class);
    @NonNull
    @Autowired
    private final BankService bankService;

    private final BankMapper mapper = BankMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<BankDto> saveBank(@RequestBody BankDto bankDto) {
        Bank savedBank;

        try {
            savedBank = bankService.createBank(mapper.convertToEntity(bankDto));

        } catch (NullPointerException | NameOfTheBankAlreadyExistException exception) {
            return badRequest().build();
        }
        //
        return ok(mapper.convertToDTO(savedBank));
    }

    @DeleteMapping("/{idBank}")
    void deleteBank(@PathVariable Integer idBank) {
        Bank bank=bankService.findById(idBank);
        bankService.deleteBank(bank);
    }

    @GetMapping("/get/{idBank}")
    public ResponseEntity<BankDto> getBankById(@PathVariable("idBank") Integer idBank) {

        Bank bank;
        try{
            bank = bankService.findById(idBank);
        } catch (NullPointerException exception) {
            return notFound().build();
        }
        return ok(mapper.convertToDTO(bank));
    }

    @PutMapping("/put/{idBank}")
    public ResponseEntity<BankDto> updateBankName(@PathVariable("idBank") Integer idBank, String name){
        Bank bank;
        try{
            bank = bankService.findById(idBank);
            bankService.updateBankName(name, bank);


        } catch (NullPointerException exception) {
            return notFound().build();
        }

        return ok(mapper.convertToDTO(bank));
    }







}
