package ru.itis.diplom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.diplom.exception.BackendException;
import ru.itis.diplom.exception.TaskBelongsToAnotherUser;
import ru.itis.diplom.exception.TaskNotFoundException;
import ru.itis.diplom.mapper.TaskMapper;
import ru.itis.diplom.model.Task;
import ru.itis.diplom.model.dto.StatusDTO;
import ru.itis.diplom.model.dto.TaskDTO;
import ru.itis.diplom.model.dto.TemplateDTO;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.model.enumeration.Permission;
import ru.itis.diplom.model.enumeration.Status;
import ru.itis.diplom.repository.TaskRepository;
import ru.itis.diplom.utils.SecurityUtil;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final TaskMapper taskMapper;
    private final ProjectService projectService;

    public List<TaskDTO> getAll() {
        return taskMapper.toTaskDTOs(taskRepository.findAll());
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.toTask(taskDTO);
//        task.setProject(projectService.getProjectById(taskDTO.getProject()));
        task.setStatus(Status.BACKLOG);
        task.setAssignee(userService.getUserById(taskDTO.getAssignee()));
        task.setReporter(userService.getUserById(taskDTO.getReporter()));
        task.setSubTask(Objects.nonNull(taskDTO.getSubTask()) ? taskDTO.getSubTask().stream().map(this::getTaskById).collect(Collectors.toList()) : null);
        task.setNextTask(Objects.nonNull(taskDTO.getNextTask()) ? taskDTO.getNextTask().stream().map(this::getTaskById).collect(Collectors.toList()) : null);
        task.setDateInsert(new Timestamp(System.currentTimeMillis()));
        task.setDateUpdate(new Timestamp(System.currentTimeMillis()));

        return taskMapper.toTaskDTO(taskRepository.save(task));
    }

    public TemplateDTO createTaskFromTemplate(TemplateDTO templateDTO, long projectId) {
        Task task = taskMapper.toTask(templateDTO);
        task.setProject(projectService.getProjectById(projectId));
        task.setStatus(Status.BACKLOG);
        task.setAssignee(userService.getUserById(templateDTO.getAssignee()));
        task.setReporter(userService.getUserById(templateDTO.getReporter()));
        task.setDateInsert(new Timestamp(System.currentTimeMillis()));
        task.setDateUpdate(new Timestamp(System.currentTimeMillis()));
        Task createdTask = taskRepository.save(task);
        templateDTO.setTaskId(createdTask.getId());

        return templateDTO;
    }

    public Task getTaskById(Long id) {
        if (Objects.isNull(id)) {
            throw new BackendException(BackendException.TASK_ID_NULL);
        }
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.orElseThrow(TaskNotFoundException::new);
    }

    public TaskDTO updateTask(long id, TaskDTO taskDTO, Principal principal) {
        Task task = getTaskById(id);
        UserDTO authCredentials = SecurityUtil.parseUser(principal);
        if ((task.getReporter() != null && !authCredentials.getUserId().equals(task.getReporter().getEmail()))
                || (task.getAssignee() != null && !authCredentials.getUserId().equals(task.getAssignee().getEmail()))) {
            if (!authCredentials.getRoles().contains(Permission.ADMIN_WRITE.getPermission())) {
                throw new TaskBelongsToAnotherUser();
            }
        }
        if (!taskDTO.getReporter().equals(task.getReporter().getId())) {
            task.setReporter(userService.getUserById(taskDTO.getReporter()));
        }
        if (!taskDTO.getAssignee().equals(task.getAssignee().getId())) {
            task.setAssignee(userService.getUserById(taskDTO.getAssignee()));
        }
        task.setNextTask(taskDTO.getNextTask().stream().map(this::getTaskById).collect(Collectors.toList()));
        task.setSubTask(taskDTO.getSubTask().stream().map(this::getTaskById).collect(Collectors.toList()));
        task.setDateUpdate(new Timestamp(System.currentTimeMillis()));
        return taskMapper.toTaskDTO(taskRepository.save(task));
    }

    public TaskDTO updateTaskStatus(long id, String status) {
        Task task = getTaskById(id);
        task.setStatus(Status.valueOf(status));
        return taskMapper.toTaskDTO(taskRepository.save(task));
    }
}
