package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.BankAccount;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.EXPLICIT)
public interface BankAccountMapper {
    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    @Named(value = "bankAccountToBankAccountDTO")
    BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount);

    @InheritInverseConfiguration(name = "bankAccountToBankAccountDTO")
    BankAccount bankAccountDTOToBankAccount(BankAccountDTO bankAccountDTO);

    @Named(value = "convertToDTOShow")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "idAccount", target = "idAccount")
    @Mapping(source = "balance", target = "balance")
    @Mapping(source = "currency", target = "currency")
    @Mapping(source = "accountType", target = "accountType")
    BankAccountDTO convertToDTOShow(BankAccount bankAccount);

    @InheritInverseConfiguration(name = "convertToDTOShow")
    BankAccount convertToBankAccountShow(BankAccountDTO bankAccountDTO);


    @IterableMapping(qualifiedByName = "convertToDTOShow")
    List<BankAccountDTO> bankAccountsToDTO(List<BankAccount> accountDTOS);
}
