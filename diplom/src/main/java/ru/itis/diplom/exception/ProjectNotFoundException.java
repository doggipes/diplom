package ru.itis.diplom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "PROJECT_NOT_FOUND")
public class ProjectNotFoundException extends RuntimeException {
}
