package ru.itis.diplom.model.dto;

import lombok.Data;

@Data
public class AuthDTO {

    private String email;

    private String login;

    private String firstname;

    private String lastname;

    private String password;

}
