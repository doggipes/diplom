package ru.itis.diplom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.diplom.exception.BackendException;
import ru.itis.diplom.exception.TemplateNotFoundException;
import ru.itis.diplom.exception.UserDoesNotHavePermission;
import ru.itis.diplom.mapper.TaskMapper;
import ru.itis.diplom.model.Project;
import ru.itis.diplom.model.Template;
import ru.itis.diplom.model.dto.TemplateDTO;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.model.enumeration.Permission;
import ru.itis.diplom.repository.TemplateRepository;
import ru.itis.diplom.utils.JsonUtil;
import ru.itis.diplom.utils.SecurityUtil;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final TaskMapper taskMapper;
    private final TemplateRepository templateRepository;

    public void DFSTemplate(TemplateDTO templateDTO, long projectId) {
        templateDTO = taskService.createTaskFromTemplate(templateDTO, projectId);
        if (!templateDTO.getSubTask().isEmpty()) {
            for (TemplateDTO dto : templateDTO.getSubTask()) {
                if (!dto.hasTaskId()) {
                    DFSTemplate(dto, projectId);
                }
            }
        }
        if (!templateDTO.getNextTask().isEmpty()) {
            for (TemplateDTO dto : templateDTO.getNextTask()) {
                if (!dto.hasTaskId()) {
                    DFSTemplate(dto, projectId);
                }
            }
        }
    }

    public void updateTemplateChildTask(TemplateDTO templateDTO, Principal principal) {
        taskService.updateTask(templateDTO.getTaskId(), taskMapper.toTaskDTO(templateDTO), principal);
        if (!templateDTO.getSubTask().isEmpty()) {
            for (TemplateDTO dto : templateDTO.getSubTask()) {
                updateTemplateChildTask(dto, principal);
            }
        }
        if (!templateDTO.getNextTask().isEmpty()) {
            for (TemplateDTO dto : templateDTO.getNextTask()) {
                updateTemplateChildTask(dto, principal);
            }
        }
    }

    public Template createTemplate(TemplateDTO templateDTO, Principal principal) {
        String json = JsonUtil.objectToJson(templateDTO);
        Template template = Template.builder()
                .name("Стройка")
                .jsonClass(json)
                .dateInsert(new Timestamp(System.currentTimeMillis()))
                .dateUpdate(new Timestamp(System.currentTimeMillis()))
                .build();
        return templateRepository.save(template);
    }

    public List<Template> getAll() {
        return templateRepository.findAll();
    }

    public Template getTemplateById(Long id) {
        if (Objects.isNull(id)) {
            throw new BackendException(BackendException.TEMPLATE_ID_NULL);
        }
        Optional<Template> templateOptional = templateRepository.findById(id);
        return templateOptional.orElseThrow(TemplateNotFoundException::new);
    }

    public TemplateDTO createTasksFromTemplate(long id, Principal principal, long projectId) {
        Template template = getTemplateById(id);
        TemplateDTO parsedFromJson = (TemplateDTO) JsonUtil.jsonToObject(template.getJsonClass(), TemplateDTO.class.getName());
        DFSTemplate(parsedFromJson, projectId);
        updateTemplateChildTask(parsedFromJson, principal);
        return parsedFromJson;
    }

    public List<Template> getByUser(Principal principal) {
        UserDTO authCredentials = SecurityUtil.parseUser(principal);
        if (!authCredentials.getRoles().contains(Permission.ADMIN_WRITE.getPermission())) {
            throw new UserDoesNotHavePermission();
        }
        return getAll();
    }
}