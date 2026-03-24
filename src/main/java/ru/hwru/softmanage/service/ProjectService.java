package ru.hwru.softmanage.service;

import org.springframework.stereotype.Service;
import ru.hwru.softmanage.entity.Project;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.entity.TimeEntry;
import ru.hwru.softmanage.enums.TaskStatus;
import ru.hwru.softmanage.repository.ProjectRepository;
import ru.hwru.softmanage.repository.TaskRepository;
import ru.hwru.softmanage.repository.TimeEntryRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final TaskRepository taskRepository;

    private final TimeEntryRepository timeEntryRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository, TimeEntryRepository timeEntryRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.timeEntryRepository = timeEntryRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public long count() {
        return projectRepository.count();
    }

    public int calculateProgress(Project project) {
        List<Task> tasks = taskRepository.findByProject(project);

        if (tasks.isEmpty()) return 0;

        long done = tasks.stream()
                .filter(t -> t.getStatus() == TaskStatus.DONE)
                .count();

        return (int) ((done * 100) / tasks.size());
    }

    public BigDecimal getProjectHours(Project project) {
        List<Task> tasks = taskRepository.findByProject(project);

        return tasks.stream()
                .flatMap(t -> timeEntryRepository.findByTask(t).stream())
                .map(TimeEntry::getHours)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
