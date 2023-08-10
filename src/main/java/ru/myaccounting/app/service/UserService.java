package ru.myaccounting.app.service;

import ru.myaccounting.app.entity.User;
import ru.myaccounting.app.payload.request.SignupRequest;

import java.security.Principal;

public interface UserService {

    User createUser(SignupRequest userIn);

    User updateUser(String firstName, String lastName, Principal principal);

    User getCurrentUser(Principal principal);

    User getUserById(Long id);
}
