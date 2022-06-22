package ru.itis.diplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.diplom.model.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByUsers_Id(Long id);

    @Transactional
    @Modifying
    @Query(
            value = "insert into public.users_projects (project_id, user_id) values (:id, :id_user)",
            nativeQuery = true)
    void addUser(@Param("id") long id, @Param("id_user") long id_user);

}
