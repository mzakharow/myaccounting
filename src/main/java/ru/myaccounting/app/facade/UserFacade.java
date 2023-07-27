package ru.myaccounting.app.facade;

import org.springframework.stereotype.Component;
import ru.myaccounting.app.dto.UserDTO;
import ru.myaccounting.app.entity.User;


@Component
public class UserFacade {

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(userDTO.getFirstname());
        userDTO.setLastname(userDTO.getLastname());
        userDTO.setUsername(userDTO.getUsername());
        return userDTO;
    }
}
