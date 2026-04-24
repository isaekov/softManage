package ru.hwru.softmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hwru.softmanage.dto.UserRequest;
import ru.hwru.softmanage.entity.Role;
import ru.hwru.softmanage.entity.User;
import ru.hwru.softmanage.repository.RoleRepository;
import ru.hwru.softmanage.service.UserService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    // список пользователей
    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "layout";
    }

    // форма создания
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new UserRequest());
        model.addAttribute("roles", roleRepository.findAll());
        return "layout";
    }

    // сохранение
    @PostMapping("/create")
    public String create(@ModelAttribute UserRequest request) {
        userService.createUser(request);
        return "redirect:/users";
    }

    // форма редактирования
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {

        User user = userService.findById(id);

        UserRequest request = new UserRequest();
        request.setName(user.getName());
        request.setLastname(user.getLastname());

        request.setUsername(user.getUsername());
        request.setEmail(user.getEmail());

        request.setRoles(
                user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet())
        );

        model.addAttribute("user", request);
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("userId", id);

        return "layout";
    }

    // обновление
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       @ModelAttribute UserRequest request) {
        userService.editUser(id, request);
        return "redirect:/users";
    }
}
