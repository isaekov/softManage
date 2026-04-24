package ru.hwru.softmanage.service;

import org.springframework.stereotype.Service;
import ru.hwru.softmanage.dto.TaskRequest;
import ru.hwru.softmanage.entity.Project;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.entity.User;
import ru.hwru.softmanage.enums.TaskStatus;
import ru.hwru.softmanage.repository.TaskRepository;
import ru.hwru.softmanage.repository.UserRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> findByProject(Project project) {
        return taskRepository.findByProject(project);
    }

    public Task create(TaskRequest request) {
        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());


        task.setStatus(request.getStatus());
        task.setProject(request.getProject());

        if (request.getAssigned() != null) {
            User user = userRepository.findById(request.getAssigned().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            task.setAssigned(user);
        }

        return taskRepository.save(task);

    }

    public Task update(long id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        task.setStatus(request.getStatus());
        task.setProject(request.getProject());

        if (request.getAssigned() != null) {
            task.setAssigned(request.getAssigned());
        }

        return taskRepository.save(task);

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

    public List<Task> findByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> findMyTasks(String username) {
        return taskRepository.findByAssignedUsername(username);
    }

}
