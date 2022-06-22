package ru.itis.diplom.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum Permission {
    OPERATOR_WRITE("operator:write"),
    OPERATOR_READ("operator:read"),

    INSPECTOR_WRITE("operator:write"),
    INSPECTOR_READ("operator:read"),

    ADMIN_WRITE("admin:write"),
    ADMIN_READ("admin:read");

    @Getter
    private final String permission;

}
