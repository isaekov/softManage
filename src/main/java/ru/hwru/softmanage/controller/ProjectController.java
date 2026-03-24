package ru.hwru.softmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hwru.softmanage.entity.Project;
import ru.hwru.softmanage.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
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
        return "layout";
    }

    // сохранение
    @PostMapping("/create")
    public String create(@ModelAttribute Project project) {
        projectService.save(project);
        return "redirect:/projects";
    }
}
