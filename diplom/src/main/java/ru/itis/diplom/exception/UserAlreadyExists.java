package ru.itis.diplom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "USER_ALREADY_EXISTS")
public class UserAlreadyExists extends RuntimeException{
}
