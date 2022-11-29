package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO userToUserDTO(User user);

    @InheritInverseConfiguration
    User userDTOtoUser(UserDTO userDTO);

    Set<UserDTO> usersTOUsersDTO(Set<User> users);
}
