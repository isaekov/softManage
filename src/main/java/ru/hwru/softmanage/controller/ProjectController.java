package ru.hwru.softmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hwru.softmanage.entity.Project;
import ru.hwru.softmanage.enums.ProjectStatus;
import ru.hwru.softmanage.enums.TaskStatus;
import ru.hwru.softmanage.service.ProjectService;
import ru.hwru.softmanage.service.TaskService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    private final TaskService taskService;

    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    // список проектов
    @GetMapping
    public String list(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "layout";

    }

    // форма создания
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("statuses", ProjectStatus.values());

        return "layout";
    }

    // сохранение
    @PostMapping("/create")
    public String create(@ModelAttribute Project project) {
        projectService.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {

        Project project = projectService.findById(id);

        model.addAttribute("project", project);
        model.addAttribute("tasks", taskService.findByProject(project));
        model.addAttribute("progress", projectService.calculateProgress(project));
        model.addAttribute("hours", projectService.getProjectHours(project));

        return "layout";
    }
}
