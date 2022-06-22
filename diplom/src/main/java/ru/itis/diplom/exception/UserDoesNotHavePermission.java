package ru.itis.diplom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "USER_DOES_NOT_HAVE_PERMISSION")
public class UserDoesNotHavePermission extends RuntimeException{
}
