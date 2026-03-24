package ru.hwru.softmanage.service;

import org.springframework.stereotype.Service;
import ru.hwru.softmanage.entity.Project;
import ru.hwru.softmanage.entity.Task;
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
}
