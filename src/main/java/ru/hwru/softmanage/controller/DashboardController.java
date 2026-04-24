package ru.hwru.softmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hwru.softmanage.entity.User;
import ru.hwru.softmanage.enums.TaskStatus;
import ru.hwru.softmanage.repository.TaskRepository;
import ru.hwru.softmanage.repository.UserRepository;
import ru.hwru.softmanage.service.ProjectService;
import ru.hwru.softmanage.service.TaskService;
import ru.hwru.softmanage.service.TimeEntryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    private final ProjectService projectService;
    private final TaskService taskService;
    private final TimeEntryService timeEntryService;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public DashboardController(ProjectService projectService,
                               TaskService taskService,
                               TimeEntryService timeEntryService, TaskRepository taskRepository, UserRepository userRepository) {
        this.projectService = projectService;
        this.taskService = taskService;
        this.timeEntryService = timeEntryService;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

//    @GetMapping("/dashboard")
//    public String dashboard(Model model) {
//
//        model.addAttribute("projectsCount", projectService.count());
//        model.addAttribute("tasksCount", taskService.count());
//        model.addAttribute("timeEntriesCount", timeEntryService.count());
//        model.addAttribute("totalHours", timeEntryService.getTotalHours());
//
//        return "layout";
//    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        long total = taskRepository.count();
        long newTasks = taskRepository.countByStatus(TaskStatus.NEW);
        long inProgress = taskRepository.countByStatus(TaskStatus.IN_PROGRESS);
        long done = taskRepository.countByStatus(TaskStatus.DONE);

        List<User> users = userRepository.findAll();

        Map<String, Long> tasksByUser = new HashMap<>();
        for (User u : users) {
            long count = taskRepository.countByAssignedUsername(u.getUsername());
            tasksByUser.put(u.getName(), count);
        }

        model.addAttribute("total", total);
        model.addAttribute("newTasks", newTasks);
        model.addAttribute("inProgress", inProgress);
        model.addAttribute("done", done);
        model.addAttribute("tasksByUser", tasksByUser);

        model.addAttribute("projectsCount", projectService.count());
        model.addAttribute("tasksCount", taskService.count());
        model.addAttribute("timeEntriesCount", timeEntryService.count());
        model.addAttribute("totalHours", timeEntryService.getTotalHours());

        return "layout";
    }
}
