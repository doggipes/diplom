package ru.itis.diplom.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.security.details.UserDetailsImpl;

import java.security.Principal;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class SecurityUtil {

    public static UserDTO parseUser(Principal principal) {
        if (principal instanceof AbstractAuthenticationToken) {
            AbstractAuthenticationToken token = (AbstractAuthenticationToken) principal;
            UserDetailsImpl userDetails = (UserDetailsImpl) token.getPrincipal();

            return UserDTO.builder()
                    .roles(token.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .login(userDetails.getUser().getLogin())
                    .fullName(Stream
                            .of(
                                    userDetails.getUser().getFirstname(),
                                    userDetails.getUser().getLastname()
                            )
                            .filter(Objects::nonNull)
                            .collect(Collectors.joining(" "))
                    )
                    .firstname(userDetails.getUser().getFirstname())
                    .lastname(userDetails.getUser().getLastname())
                    .email(token.getName())
                    .userId(userDetails.getUser().getId())
                    .build();
        }
        return null;
    }

}
