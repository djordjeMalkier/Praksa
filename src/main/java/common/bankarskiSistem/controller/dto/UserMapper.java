package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO usertoUserDTO(User user);
    User userDTOtoUser(UserDTO userDTO);
}
