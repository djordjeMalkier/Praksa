package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.BankAccount;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BankAccountMapper {
    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    @Mapping(source = "idAccount", target = "idAccount")
    @Mapping(source = "balance", target = "balance")
    @Mapping(source = "currency", target = "currency")
    @Mapping(source = "accountType", target = "accountType")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "bank", target = "bank")
    BankAccountDTO convertToDTO(BankAccount bankAccount);

    @InheritInverseConfiguration
    BankAccount convertToEntity(BankAccountDTO bankAccountDTO);
}
