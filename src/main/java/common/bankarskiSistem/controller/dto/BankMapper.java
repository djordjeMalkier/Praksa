package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.Bank;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BankMapper {
    BankMapper INSTANCE = Mappers.getMapper(BankMapper.class);

    @Mapping(source = "idBank", target = "idBank")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "bankAccounts", target = "bankAccounts")
    @Mapping(source = "exchangeRates", target = "exchangeRatesDTO")
    BankDto convertToDTO(Bank bank);

    @InheritInverseConfiguration
    Bank convertToEntity(BankDto bankDto);

    List<BankDto> bankToBankDTO(List<Bank> banks);
}
