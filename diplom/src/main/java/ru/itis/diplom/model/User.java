package ru.itis.diplom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import ru.itis.diplom.model.enumeration.Role;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(callSuper = false, exclude = {"projects", "tasks"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "users_projects",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "project_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Project> projects;

    private String login;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private Role role;

}
