package ru.hwru.softmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.service.ProjectService;
import ru.hwru.softmanage.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;

    public TaskController(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    // список всех задач
    @GetMapping
    public String list(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "layout";
    }

    // форма создания
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("projects", projectService.findAll()); // для select
        return "layout";
    }

    // сохранение
    @PostMapping("/create")
    public String create(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }
}