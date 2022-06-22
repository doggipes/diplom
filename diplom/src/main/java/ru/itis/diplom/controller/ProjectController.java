package ru.itis.diplom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplom.model.Project;
import ru.itis.diplom.model.Template;
import ru.itis.diplom.model.User;
import ru.itis.diplom.model.dto.ProjectCreateDTO;
import ru.itis.diplom.model.dto.ProjectCreateWithTemplateDTO;
import ru.itis.diplom.model.dto.TaskDTO;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.repository.ProjectRepository;
import ru.itis.diplom.repository.UserRepository;
import ru.itis.diplom.service.ProjectService;
import ru.itis.diplom.service.TemplateService;
import ru.itis.diplom.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;
    private final TemplateService templateService;
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/projects")
    @ResponseStatus(HttpStatus.OK)
    public String getProjects(Principal principal, Model model) {
        List<Project> projects = projectService.getByUser(principal);
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/project/create")
    @ResponseStatus(HttpStatus.OK)
    public String getCreateProject(Principal principal, Model model) {
        return "createProject";
    }

    @GetMapping("/project/template/create")
    @ResponseStatus(HttpStatus.OK)
    public String createTasksFromTemplate(Model model, Principal principal) {
        List<Template> templates = templateService.getAll();
        model.addAttribute("templates", templates);
        return "createProjectFromTemplate";
    }

    @GetMapping("/project/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getProject(Principal principal, Model model, @PathVariable long id) {
        Project project = projectService.getProjectById(id);
        List<UserDTO> users = userService.getAll();
        model.addAttribute("project", project);
        model.addAttribute("users", users);
        return "project";
    }

    @PostMapping("/project/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String setUser(Principal principal, Model model, @PathVariable long id, long id_user) {
        projectRepository.addUser(id, id_user);
        Project project = projectService.getProjectById(id);
        List<UserDTO> users = userService.getAll();
        model.addAttribute("project", project);
        model.addAttribute("users", users);
        return "project";
    }

    @PostMapping("/project/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(ProjectCreateDTO projectCreateDTO, Principal principal) {
        return projectService.createProject(projectCreateDTO, principal);
    }

    @PostMapping("/project/template/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProjectFromTemplate(ProjectCreateWithTemplateDTO projectCreateDTO, Principal principal) {
        Project project = projectService.createProject(projectCreateDTO, principal);
        templateService.createTasksFromTemplate(projectCreateDTO.getTemplateId(), principal, project.getId());
        return "createProjectFromTemplate";
    }

}
