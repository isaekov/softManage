package ru.hwru.softmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hwru.softmanage.service.ProjectService;
import ru.hwru.softmanage.service.TaskService;
import ru.hwru.softmanage.service.TimeEntryService;

@Controller
public class DashboardController {

    private final ProjectService projectService;
    private final TaskService taskService;
    private final TimeEntryService timeEntryService;

    public DashboardController(ProjectService projectService,
                               TaskService taskService,
                               TimeEntryService timeEntryService) {
        this.projectService = projectService;
        this.taskService = taskService;
        this.timeEntryService = timeEntryService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("projectsCount", projectService.count());
        model.addAttribute("tasksCount", taskService.count());
        model.addAttribute("timeEntriesCount", timeEntryService.count());
        model.addAttribute("totalHours", timeEntryService.getTotalHours());

        return "layout";
    }
}
