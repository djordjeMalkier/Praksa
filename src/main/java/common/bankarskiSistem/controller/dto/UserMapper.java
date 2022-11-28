package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "personalId", target = "personalId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "bankAccounts", target = "bankAccounts")
    UserDTO userToUserDTO(User user);

    @InheritInverseConfiguration
    User userDTOtoUser(UserDTO userDTO);

    Set<UserDTO> usersTOUsersDTO(Set<User> users);
}
