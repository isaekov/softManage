package ru.hwru.softmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hwru.softmanage.entity.TaskComment;

import java.util.List;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long> {

    List<TaskComment> findByTaskIdOrderByCreatedAtAsc(Long taskId);

}
