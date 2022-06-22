package ru.itis.diplom.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemplateDTO {

    private Long taskId;
    private String name;
    private String description;
    private Long project;
    private Long reporter;
    private Long assignee;
    private List<TemplateDTO> nextTask;
    private List<TemplateDTO> subTask;
    private Timestamp dateStart;
    private Timestamp dateEnd;

    public boolean hasTaskId() {
        return taskId != null;
    }

}
