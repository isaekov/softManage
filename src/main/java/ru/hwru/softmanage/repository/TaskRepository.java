package ru.hwru.softmanage.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.hwru.softmanage.entity.Project;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.enums.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByProject(Project project);

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByAssignedUsername(String username);
}
