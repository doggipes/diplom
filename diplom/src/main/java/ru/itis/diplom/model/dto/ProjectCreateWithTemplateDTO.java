package ru.itis.diplom.model.dto;

import lombok.Data;

@Data
public class ProjectCreateWithTemplateDTO extends ProjectCreateDTO{

    private Long templateId;

}
