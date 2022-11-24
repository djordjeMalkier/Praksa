package common.bankarskiSistem.controller.dto;

import common.bankarskiSistem.model.User;

public class UserMapperImpl implements UserMapper{
    @Override
    public UserDTO usertoUserDTO(User user) {
        if(user == null){
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setPersonalId(user.getPersonalId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setAddress(user.getAddress());
        return userDTO;

       /* return new UserDTO(
                user.getPersonalId(),
                user.getName(),
                user.getSurname(),
                user.getAddress(),
                user.getBankAccounts()
        );*/
    }

    @Override
    public User userDTOtoUser(UserDTO userDTO) {
        if(userDTO == null){
            return null;
        }

        User user = new User();

        user.setPersonalId(user.getPersonalId());
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setAddress(user.getAddress());
        return user;

    }

}
