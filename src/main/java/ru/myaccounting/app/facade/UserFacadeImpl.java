package ru.myaccounting.app.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.myaccounting.app.dto.UserDTO;
import ru.myaccounting.app.entity.User;
import ru.myaccounting.app.payload.request.SignupRequest;
import ru.myaccounting.app.service.UserService;

import java.security.Principal;


@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    public UserDTO userToUserDTO(Principal principal) {
        User user = userService.getCurrentUser(principal);
        UserDTO userDTO = createUserDTO(user);
        return userDTO;
    }

    public UserDTO userToUserDTOByName(String userId) {
        User user = userService.getUserById(Long.parseLong(userId));
        UserDTO userDTO = createUserDTO(user);
        return userDTO;
    }

    public UserDTO userUpdate(UserDTO userDTO, Principal principal) {
        User userUpdated = userService.updateUser(userDTO.getFirstname(), userDTO.getLastname(), principal);

        return createUserDTO(userUpdated);
    }

    public void createUser(SignupRequest signupRequest) {
        userService.createUser(signupRequest);
    }

    private UserDTO createUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getName());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }
}
