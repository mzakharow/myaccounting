package ru.myaccounting.app.service;

import ru.myaccounting.app.dto.UserDTO;
import ru.myaccounting.app.entity.User;
import ru.myaccounting.app.payload.request.SignupRequest;

import java.security.Principal;

public interface UserService {

    User createUser(SignupRequest userIn);

    User updateUser(UserDTO userDTO, Principal principal);

    User getCurrentUser(Principal principal);

    User getUserById(Long id);
}
