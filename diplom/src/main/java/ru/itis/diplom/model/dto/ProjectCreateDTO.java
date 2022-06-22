package ru.itis.diplom.model.dto;

import lombok.Data;

@Data
public class ProjectCreateDTO {

    private String name;
    private String description;
    private double price;

}
