package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.ExchangeRates;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeRatesMapper {
    ExchangeRatesMapper INSTANCE = Mappers.getMapper(ExchangeRatesMapper.class);

    ExchangeRatesDTO convertToDTO(ExchangeRates exchangeRates);

    @InheritInverseConfiguration
    ExchangeRates convertToEntity(ExchangeRatesDTO exchangeRatesDTO);

}
