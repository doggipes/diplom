package ru.itis.diplom.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.diplom.model.Task;
import ru.itis.diplom.model.dto.TaskDTO;
import ru.itis.diplom.model.dto.TemplateDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public interface TaskMapper {

    @Mapping(target = "id", source = "taskId")
    @Mapping(target = "reporter", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    @Mapping(target = "nextTask", ignore = true)
    @Mapping(target = "subTask", ignore = true)
    @Mapping(target = "project", ignore = true)
    Task toTask(TaskDTO taskDTO);

    @Mapping(target = "taskId", source = "id")
    @Mapping(target = "reporter", expression = "java(task.getReporter() != null ? task.getReporter().getId() : null)")
    @Mapping(target = "assignee", expression = "java(task.getAssignee() != null ? task.getAssignee().getId() : null)")
    @Mapping(target = "nextTask", expression = "java(task.getNextTask() != null ? task.getNextTask().stream().map(Task::getId).collect(Collectors.toList()) : null)")
    @Mapping(target = "subTask", expression = "java(task.getSubTask() != null ? task.getSubTask().stream().map(Task::getId).collect(Collectors.toList()) : null)")
    @Mapping(target = "project", expression = "java(task.getProject().getId())")
    TaskDTO toTaskDTO(Task task);

    @Mapping(target = "nextTask", expression = "java(templateDTO.getNextTask() != null ? templateDTO.getNextTask().stream().map(TemplateDTO::getTaskId).collect(Collectors.toList()) : null)")
    @Mapping(target = "subTask", expression = "java(templateDTO.getSubTask() != null ? templateDTO.getSubTask().stream().map(TemplateDTO::getTaskId).collect(Collectors.toList()) : null)")
    TaskDTO toTaskDTO(TemplateDTO templateDTO);

    List<TaskDTO> toTaskDTOs(List<Task> tasks);

    @Mapping(target = "reporter", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    @Mapping(target = "nextTask", ignore = true)
    @Mapping(target = "subTask", ignore = true)
    @Mapping(target = "project", ignore = true)
    Task toTask(TemplateDTO templateDTO);

}
