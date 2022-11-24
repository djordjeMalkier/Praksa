package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.User;

public class UserMapperImpl implements UserMapper{
    @Override
    public UserDTO usertoUserDTO(User user) {
        if(user == null){
            return null;
        }

        return new UserDTO(
                user.getPersonalId(),
                user.getName(),
                user.getSurname(),
                user.getAddress(),
                user.getBankAccounts()
        );
    }

    @Override
    public User userDTOtoUser(UserDTO userDTO) {
        if(userDTO == null){
            return null;
        }

        return new User(
                userDTO.getPersonalId(),
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getAddress(),
                userDTO.getBankAccounts()
        );
    }

}
