package common.bankarskiSistem.controller;

import common.bankarskiSistem.controller.dto.BankDto;
import common.bankarskiSistem.controller.dto.BankMapper;
import common.bankarskiSistem.exceptions.NameOfTheBankAlreadyExistException;
import common.bankarskiSistem.model.Bank;
import common.bankarskiSistem.service.BankService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RequestMapping(value="/bank")
@RequiredArgsConstructor
@RestController
public class BankController {


    @NonNull
    private final BankService bankService;

    private BankMapper mapper
            = Mappers.getMapper(BankMapper.class);

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



}
