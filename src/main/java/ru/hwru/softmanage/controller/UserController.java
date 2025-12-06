package ru.hwru.softmanage.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hwru.softmanage.dto.UserRequest;
import ru.hwru.softmanage.service.UserService;

@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserRequest request) {
        userService.createUser(request);
        return "layout";
    }

    @PutMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, @RequestBody UserRequest request) {
        userService.editUser(id, request);
        return "layout";
    }
}
