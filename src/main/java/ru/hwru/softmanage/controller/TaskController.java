package ru.hwru.softmanage.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hwru.softmanage.dto.TaskRequest;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.entity.User;
import ru.hwru.softmanage.enums.TaskStatus;
import ru.hwru.softmanage.security.CustomUserDetails;
import ru.hwru.softmanage.service.ProjectService;
import ru.hwru.softmanage.service.TaskCommentService;
import ru.hwru.softmanage.service.TaskService;
import ru.hwru.softmanage.service.UserService;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserService userService;
    private final TaskCommentService taskCommentService;

    public TaskController(TaskService taskService, ProjectService projectService, UserService userService, TaskCommentService taskCommentService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
        this.taskCommentService = taskCommentService;
    }

    // список всех задач
    @GetMapping
    public String list(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "layout";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model,  Authentication auth) {

        Task task = taskService.findById(id);

        String username = auth.getName(); // возвращает логин
        User currentUser = userService.findByUsername(username);

        // Проверяем: это исполнитель ИЛИ админ?
        boolean canEdit = task.getAssigned() != null
                && task.getAssigned().getId().equals(currentUser.getId())
                || currentUser.getRoles().stream()
                .anyMatch(r -> "ADMIN".equals(r.getName()));

        model.addAttribute("task", task);
        model.addAttribute("comments", taskCommentService.getByTask(id));
        model.addAttribute("canEditTask", canEdit);

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

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {

        Task task = taskService.findById(id);

        TaskRequest request = new TaskRequest();
        request.setTitle(task.getTitle());
        request.setDescription(task.getDescription());
        request.setStatus(task.getStatus());
        request.setPriority(task.getPriority());
        request.setDeadline(task.getDeadline());
        request.setAssigned(task.getAssigned());
        request.setProject(task.getProject());

        model.addAttribute("task", request);
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("taskId", id);
        model.addAttribute("users", userService.findAll());
        model.addAttribute("statuses", TaskStatus.values());

        return "layout";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       @ModelAttribute TaskRequest request) {

        taskService.update(id, request);

        return "redirect:/tasks/" + id;
    }

    @PostMapping("/{id}/status")
    public String changeStatus(@PathVariable Long id) {
        taskService.changeStatus(id);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/comments")
    public String addComment(@PathVariable Long id,
                             @RequestParam String text,
                             Principal principal) {

        taskCommentService.addComment(id, text, principal.getName());

        return "redirect:/tasks/" + id;
    }

    @GetMapping("/kanban")
    public String kanban(Model model) {

        model.addAttribute("newTasks", taskService.findByStatus(TaskStatus.NEW));
        model.addAttribute("inProgressTasks", taskService.findByStatus(TaskStatus.IN_PROGRESS));
        model.addAttribute("doneTasks", taskService.findByStatus(TaskStatus.DONE));
        model.addAttribute("users", userService.findAll());

        return "layout";
    }

    @GetMapping("/my")
    public String my(Model model, Principal principal) {

        String username = principal.getName();

        model.addAttribute("tasks", taskService.findMyTasks(username));

        return "layout";
    }
}