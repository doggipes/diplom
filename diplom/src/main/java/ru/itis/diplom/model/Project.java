package ru.itis.diplom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
@EqualsAndHashCode(callSuper = false, exclude = {"users", "tasks"})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String description;

    private double price;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<User> users;

    @OneToMany(mappedBy = "project",
               fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private Set<Task> tasks;

}
