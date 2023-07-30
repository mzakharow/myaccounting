package ru.myaccounting.app.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {
    private Long id;
    @NotEmpty
    private String firstname;
    private String lastname;
    private String username;
}
