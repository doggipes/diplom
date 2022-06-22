package ru.itis.diplom.model;

import lombok.*;
import ru.itis.diplom.model.enumeration.Status;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
@EqualsAndHashCode(callSuper = false, exclude = "project")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id")
    private Project project;

    private String name;

    private String description;

    @OneToOne
    @JoinColumn(name = "reporter_id")
    private User reporter;

    @OneToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany
    @JoinColumn(name = "next_task")
    private List<Task> nextTask;

    @OneToMany
    @JoinColumn(name = "sub_task")
    private List<Task> subTask;

    private Timestamp dateStart;

    private Timestamp dateEnd;

    private Timestamp dateInsert;

    private Timestamp dateUpdate;

}
