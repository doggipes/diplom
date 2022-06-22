package ru.itis.diplom.model.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;
    private String email;
    private String login;
    private String fullName;
    private String firstname;
    private String lastname;
    private List<String> roles;

}
