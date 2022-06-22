package ru.itis.diplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.diplom.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

//    private List<Task> tasks;
//
//    public TaskRepository() {
//        List<Task> tasks = new ArrayList<>();
//        tasks.add(new Task("Документация", 1L, "Подготовка документации", null, null, Status.BACKLOG, null, null));
//        tasks.add(new Task("Согласование", 2L, "Отправка документации на согласование", null, null, Status.BACKLOG, null, null));
//        tasks.add(new Task("Проектирование", 3L, "Проектирование объекта", null, null, Status.BACKLOG, null, null));
//        this.tasks = tasks;
//    }

    List<Task> findAll();

}
