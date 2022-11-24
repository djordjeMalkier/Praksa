package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.Bank;
import org.mapstruct.Mapper;

@Mapper
public interface BankMapper {
    BankDto convertToDTO(Bank bank);

    Bank convertToEntity(BankDto bankDto);
}
