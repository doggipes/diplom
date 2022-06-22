package ru.itis.diplom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getLoginPage(Authentication authentication, Model model) {
        return "login";
    }

}
