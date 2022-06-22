package ru.itis.diplom.model.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class TaskDTO {

    private Long taskId;
    private String name;
    private String description;
    private Long project;
    private Long reporter;
    private Long assignee;
    private List<Long> nextTask;
    private List<Long> subTask;
    private Timestamp dateStart;
    private Timestamp dateEnd;

}
