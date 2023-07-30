package ru.myaccounting.app.facade;

import ru.myaccounting.app.dto.UserDTO;

import java.security.Principal;

public interface UserFacade {

    UserDTO userToUserDTO(Principal principal);

    UserDTO userToUserDTOByName(String userId);

    UserDTO userUpdate(UserDTO userDTO, Principal principal);
}
