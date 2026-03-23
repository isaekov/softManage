package ru.hwru.softmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hwru.softmanage.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
