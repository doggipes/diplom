package ru.itis.diplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.diplom.model.Template;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
}
