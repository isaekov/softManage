package ru.hwru.softmanage.dto;


import ru.hwru.softmanage.entity.*;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Set<String> roles;
    private Set<String> positions;

    public static UserDto from(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        dto.setPositions(user.getPositions().stream().map(Position::getTitle).collect(Collectors.toSet()));
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPositions() {
        return positions;
    }

    public void setPositions(Set<String> positions) {
        this.positions = positions;
    }
}

