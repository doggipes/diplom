package ru.itis.diplom.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.diplom.model.User;
import ru.itis.diplom.model.enumeration.Role;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ExtendedUserProfileDTO {

    public ExtendedUserProfileDTO(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    private String login;
    private String password;
    private List<Role> roles;

}
