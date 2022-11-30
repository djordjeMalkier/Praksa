package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.Conversion;
import common.bankarskiSistem.model.ExchangeRates;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExchangeRatesMapper {
    ExchangeRatesMapper INSTANCE = Mappers.getMapper(ExchangeRatesMapper.class);

    ExchangeRatesDTO convertToDTO(ExchangeRates exchangeRates);

    @InheritInverseConfiguration
    ExchangeRates convertToEntity(ExchangeRatesDTO exchangeRatesDTO);

    List<Conversion> convertDTOToEntity(List<ConversionDTO> conversionDTO);
    List<ConversionDTO> convertEntityToDTO(List<Conversion> conversion);
}
