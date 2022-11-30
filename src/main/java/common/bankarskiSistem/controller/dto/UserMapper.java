package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.EXPLICIT)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Named(value = "userToUserDTO")
    UserDTO userToUserDTO(User user);

    @InheritInverseConfiguration(name = "userToUserDTO")
    User userDTOtoUser(UserDTO userDTO);

    Set<UserDTO> usersTOUsersDTO(Set<User> users);

    @Named(value = "userToUserDTOShow")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source="personalId", target="personalId")
    @Mapping(source="name", target="name")
    @Mapping(source="surname", target="surname")
    @Mapping(source="address", target="address")
    UserDTO userToUserDTOShow(User savedUser);
}
