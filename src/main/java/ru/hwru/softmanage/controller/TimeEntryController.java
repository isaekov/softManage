package ru.hwru.softmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hwru.softmanage.entity.TimeEntry;
import ru.hwru.softmanage.service.TaskService;
import ru.hwru.softmanage.service.TimeEntryService;

@Controller
@RequestMapping("/time")
public class TimeEntryController {

    private final TimeEntryService timeEntryService;
    private final TaskService taskService;

    public TimeEntryController(TimeEntryService timeEntryService, TaskService taskService) {
        this.timeEntryService = timeEntryService;
        this.taskService = taskService;
    }

    // список записей
    @GetMapping
    public String list(Model model) {
        model.addAttribute("entries", timeEntryService.findAll());
        return "layout";
    }

    // форма создания
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("entry", new TimeEntry());
        model.addAttribute("tasks", taskService.findAll());
        return "layout";
    }

    // сохранение
    @PostMapping("/create")
    public String create(@ModelAttribute TimeEntry entry) {
        timeEntryService.save(entry);
        return "redirect:/time";
    }
}
