package ru.itis.diplom.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Status {

    BACKLOG(Status.BACKLOG_VALUE,
            Status.BACKLOG_NAME),
    IN_PROGRESS(Status.IN_PROGRESS_VALUE,
            Status.IN_PROGRESS_NAME),
    DONE(Status.DONE_VALUE,
            Status.DONE_NAME);

    public static final String BACKLOG_VALUE = "BACKLOG";
    public static final String IN_PROGRESS_VALUE = "IN_PROGRESS";
    public static final String DONE_VALUE = "DONE";

    public static final String BACKLOG_NAME = "Бэклог";
    public static final String IN_PROGRESS_NAME = "В процессе";
    public static final String DONE_NAME = "Завершено";

    @Getter
    private final String value;

    @Getter
    private final String humanReadableName;

}
