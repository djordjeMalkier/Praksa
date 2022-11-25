package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.ExchangeRates;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeRatesMapper {
    ExchangeRatesMapper INSTANCE = Mappers.getMapper(ExchangeRatesMapper.class);

    @Mapping(source = "idExchangeRates", target = "idExchangeRates")
    @Mapping(source = "name", target = "name")
    ExchangeRatesDTO convertToDTO(ExchangeRates exchangeRates);

    @InheritInverseConfiguration
    ExchangeRates convertToEntity(ExchangeRatesDTO exchangeRatesDTO);
}
