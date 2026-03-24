package ru.hwru.softmanage.service;

import org.springframework.stereotype.Service;
import ru.hwru.softmanage.entity.Project;
import ru.hwru.softmanage.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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
}
