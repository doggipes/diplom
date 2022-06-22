package ru.itis.diplom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "TASK_ID_MUST_NOT_BE_NULL")
public class BackendException extends RuntimeException {

    public static final String TASK_ID_NULL = "ID таска null";
    public static final String USER_ID_NULL = "ID юзера null";
    public static final String PROJECT_ID_NULL = "ID проекта null";
    public static final String TEMPLATE_ID_NULL = "ID шаблона null";

    public BackendException() {
        super();
    }

    public BackendException(String message) {
        super(message);
    }

    public BackendException(String message, Throwable cause) {
        super(message, cause);
    }

}
