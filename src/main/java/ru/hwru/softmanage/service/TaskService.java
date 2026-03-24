package ru.hwru.softmanage.service;

import org.springframework.stereotype.Service;
import ru.hwru.softmanage.entity.Project;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.enums.TaskStatus;
import ru.hwru.softmanage.repository.TaskRepository;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findByProject(Project project) {
        return taskRepository.findByProject(project);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public long count() {
        return taskRepository.count();
    }

    public void changeStatus(Long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);

        if (task == null) return;

        TaskStatus status = task.getStatus();

        if (task.getStatus() == TaskStatus.NEW) {
            task.setStatus(TaskStatus.IN_PROGRESS);
        } else if (task.getStatus() == TaskStatus.IN_PROGRESS) {
            task.setStatus(TaskStatus.DONE);
        }

        taskRepository.save(task);
    }
}
