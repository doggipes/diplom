package ru.itis.diplom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "TASK_BELONGS_TO_ANOTHER_USER")
public class TaskBelongsToAnotherUser extends RuntimeException{
}
