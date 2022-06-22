package ru.itis.diplom.mapper;

import org.mapstruct.Mapper;
import ru.itis.diplom.model.Template;
import ru.itis.diplom.model.dto.TemplateDTO;

@Mapper(componentModel = "spring")
public interface TemplateMapper {

    Template toTemplate(TemplateDTO templateDTO);

}
