package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.Conversion;
import common.bankarskiSistem.model.ExchangeRates;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExchangeRatesMapper {
    ExchangeRatesMapper INSTANCE = Mappers.getMapper(ExchangeRatesMapper.class);

    @Mapping(source = "idExchangeRates", target = "idExchangeRates")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "conversions", target = "conversions")
   // @Mapping(source = "banks", target = "banks")
    ExchangeRatesDTO convertToDTO(ExchangeRates exchangeRates);

    @InheritInverseConfiguration
    ExchangeRates convertToEntity(ExchangeRatesDTO exchangeRatesDTO);

    //List<Bank> convertDtoToEntity(List<BankDto> banks);
    List<Conversion> convertDtoToEntity(List<ConversionDTO> conversions);
    /*default List<Bank> convertDtoToEntity(List<BankDto> banks) {
        return banks.stream()
                .map(dto -> new Bank(dto.getName(), dto.getAddress(), dto.getBankAccounts(), convertToEntity(dto.getExchangeRates())))
                .collect(Collectors.toList());
    }*/



}
