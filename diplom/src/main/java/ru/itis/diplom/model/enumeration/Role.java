package ru.itis.diplom.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public enum Role {
    ADMIN(Role.ADMIN_VALUE,
            Role.ADMIN_NAME,
            Stream.of(Permission.ADMIN_READ, Permission.ADMIN_WRITE)
                    .collect(Collectors.toSet()),
            1),
    INSPECTOR(Role.INSPECTOR_VALUE,
            Role.INSPECTOR_NAME,
            Stream.of(Permission.INSPECTOR_READ, Permission.INSPECTOR_WRITE)
                    .collect(Collectors.toSet()),
            2),
    OPERATOR(Role.OPERATOR_VALUE,
            Role.OPERATOR_NAME,
            Stream.of(Permission.OPERATOR_READ, Permission.OPERATOR_WRITE)
                    .collect(Collectors.toSet()),
            3);

    public static final String ADMIN_VALUE = "ADMIN";
    public static final String INSPECTOR_VALUE = "INSPECTOR";
    public static final String OPERATOR_VALUE = "OPERATOR";

    public static final String ADMIN_NAME = "Администратор";
    public static final String INSPECTOR_NAME = "Инспектор";
    public static final String OPERATOR_NAME = "Оператор";

    @Getter
    private final String value;

    @Getter
    private final String humanReadableName;

    @Getter
    private final Set<Permission> permissions;

    @Getter
    private final int priority;

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
