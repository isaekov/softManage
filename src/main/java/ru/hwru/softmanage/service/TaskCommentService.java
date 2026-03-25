package ru.hwru.softmanage.service;

import org.springframework.stereotype.Service;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.entity.TaskComment;
import ru.hwru.softmanage.entity.User;
import ru.hwru.softmanage.repository.TaskCommentRepository;
import ru.hwru.softmanage.repository.TaskRepository;
import ru.hwru.softmanage.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskCommentService {

    private final TaskCommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskCommentService(TaskCommentRepository commentRepository,
                              TaskRepository taskRepository,
                              UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public void addComment(Long taskId, String text, String username) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        TaskComment comment = new TaskComment();
        comment.setText(text);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setTask(task);
        comment.setUser(user);

        commentRepository.save(comment);
    }

    public List<TaskComment> getByTask(Long taskId) {
        return commentRepository.findByTaskIdOrderByCreatedAtAsc(taskId);
    }
}