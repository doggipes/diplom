package ru.itis.diplom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplom.model.Project;
import ru.itis.diplom.model.Template;
import ru.itis.diplom.model.dto.ProjectCreateDTO;
import ru.itis.diplom.model.dto.TemplateDTO;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.service.ProjectService;
import ru.itis.diplom.service.TemplateService;
import ru.itis.diplom.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TemplateController {

    private final TemplateService templateService;
    private final UserService userService;

    @GetMapping("/template")
    @ResponseStatus(HttpStatus.OK)
    public String getTemplates(Model model, Principal principal) {
        List<Template> templates = templateService.getByUser(principal);
        model.addAttribute("templates", templates);
        return "templates";
    }

    @GetMapping("/template/create")
    @ResponseStatus(HttpStatus.OK)
    public String createTasksFromTemplate(Model model, Principal principal) {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users", users);
        return "createTemplate";
    }

    @PostMapping("/template/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TemplateDTO createTasksFromTemplate(Principal principal, ProjectCreateDTO projectCreateDTO) {
        return null;
    }

    @PostMapping("/template")
    @ResponseStatus(HttpStatus.CREATED)
    public Template createTemplate(@RequestBody TemplateDTO templateDTO, Principal principal) {
        return templateService.createTemplate(templateDTO, principal);
    }

}
