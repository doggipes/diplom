package ru.itis.diplom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.diplom.exception.BackendException;
import ru.itis.diplom.exception.ProjectNotFoundException;
import ru.itis.diplom.exception.TaskBelongsToAnotherUser;
import ru.itis.diplom.mapper.ProjectMapper;
import ru.itis.diplom.model.Project;
import ru.itis.diplom.model.dto.ProjectCreateDTO;
import ru.itis.diplom.model.dto.UserDTO;
import ru.itis.diplom.model.enumeration.Permission;
import ru.itis.diplom.repository.ProjectRepository;
import ru.itis.diplom.utils.SecurityUtil;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public List<Project> getByUser(Principal principal) {
        UserDTO authCredentials = SecurityUtil.parseUser(principal);
        if (authCredentials.getRoles().contains(Permission.ADMIN_WRITE.getPermission())) {
            return getAll();
        }
        return projectRepository.findByUsers_Id(authCredentials.getUserId());
    }

    public Project getProjectById(Long id) {
        if (Objects.isNull(id)) {
            throw new BackendException(BackendException.PROJECT_ID_NULL);
        }
        Optional<Project> projectOptional = projectRepository.findById(id);
        return projectOptional.orElseThrow(ProjectNotFoundException::new);
    }

    public Project createProject(ProjectCreateDTO projectCreateDTO, Principal principal) {
        Project project = projectMapper.toProject(projectCreateDTO);
        return projectRepository.save(project);
    }
}
