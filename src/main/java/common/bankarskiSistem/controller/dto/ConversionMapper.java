package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.Conversion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConversionMapper {
    ConversionMapper INSTANCE = Mappers.getMapper(ConversionMapper.class);

    @Mapping(source = "idConversion", target = "idConversion")
    @Mapping(source = "currencyFrom", target = "currencyFrom")
    @Mapping(source = "currencyTo", target = "currencyTo")
    @Mapping(source = "value", target = "value")
    @Mapping(source = "exchangeRates", target = "exchangeRates")
    ConversionDTO convertToDTO(Conversion conversion);

    @InheritInverseConfiguration
    Conversion convertToEntity(ConversionDTO ConversionDTO);

}
