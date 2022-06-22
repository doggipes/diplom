package ru.itis.diplom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplom.model.Project;
import ru.itis.diplom.model.Task;
import ru.itis.diplom.model.dto.StatusDTO;
import ru.itis.diplom.model.dto.TaskDTO;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.service.ProjectService;
import ru.itis.diplom.service.TaskService;
import ru.itis.diplom.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserService userService;

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public String getTasks(Model model, Principal principal) {
        List<TaskDTO> taskDTOS = taskService.getAll();
        List<Project> projects = projectService.getByUser(principal);
        model.addAttribute("tasks", taskDTOS);
        model.addAttribute("projects", projects);
        return "tasks";
    }

    @GetMapping("/task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getTask(@PathVariable long id, Model model) {
        Task task = taskService.getTaskById(id);
        List<UserDTO> users = userService.getAll();
        model.addAttribute("task", task);
        model.addAttribute("users", users);
        return "task";
    }

    @PostMapping("/task/{id}")
    public String setStatus(@PathVariable long id, String status, Principal principal) {
        taskService.updateTaskStatus(id, status);
        return "redirect:/api/v1/task/" + id;
    }

    @PostMapping("/task")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @PutMapping("/task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO, Principal principal) {
        return taskService.updateTask(id, taskDTO, principal);
    }

}
