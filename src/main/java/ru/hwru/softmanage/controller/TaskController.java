package ru.hwru.softmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.enums.TaskStatus;
import ru.hwru.softmanage.service.ProjectService;
import ru.hwru.softmanage.service.TaskService;
import ru.hwru.softmanage.service.UserService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserService userService;

    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
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
        model.addAttribute("users", userService.findAll());
        model.addAttribute("statuses", TaskStatus.values());
        return "layout";
    }

    // сохранение
    @PostMapping("/create")
    public String create(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/status")
    public String changeStatus(@PathVariable Long id) {
        taskService.changeStatus(id);
        return "redirect:/tasks";
    }
}