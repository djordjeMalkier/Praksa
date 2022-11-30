package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.Conversion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConversionMapper {
    ConversionMapper INSTANCE = Mappers.getMapper(ConversionMapper.class);

    ConversionDTO convertToDTO(Conversion conversion);

    @InheritInverseConfiguration
    Conversion convertToEntity(ConversionDTO ConversionDTO);

}
