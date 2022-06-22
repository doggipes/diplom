package ru.itis.diplom.mapper;

import org.mapstruct.Mapper;
import ru.itis.diplom.model.Project;
import ru.itis.diplom.model.dto.ProjectCreateDTO;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project toProject(ProjectCreateDTO projectCreateDTO);

}
