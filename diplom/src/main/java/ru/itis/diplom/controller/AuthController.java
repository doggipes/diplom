package ru.itis.diplom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.model.dto.AuthDTO;
import ru.itis.diplom.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getAuth(Authentication authentication, Model model){
        return "auth";
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.OK)
    public String postAuth(AuthDTO authDTO, Model model){
        userService.auth(authDTO);
        return "auth";
    }

}
