package ru.hwru.softmanage.service;

import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hwru.softmanage.dto.UserDto;
import ru.hwru.softmanage.dto.UserRequest;
import ru.hwru.softmanage.entity.Position;
import ru.hwru.softmanage.entity.Role;
import ru.hwru.softmanage.entity.Task;
import ru.hwru.softmanage.entity.User;
import ru.hwru.softmanage.repository.PositionRepository;
import ru.hwru.softmanage.repository.RoleRepository;
import ru.hwru.softmanage.repository.UserRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PositionRepository positionRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PositionRepository positionRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.positionRepository = positionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDto createUser(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setRoles(resolveRoles(request.getRoles()));
        user.setPositions(resolvePositions(request.getPositions()));

        userRepository.save(user);
        return UserDto.from(user);
    }

    @Transactional
    public UserDto editUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        System.out.println("Ildar");
        System.out.println(request.getEmail());

        if (request.getUsername() != null) user.setUsername(request.getUsername());
        if (request.getPassword() != null) user.setPassword(passwordEncoder.encode(request.getPassword()));
        if (request.getEmail() != null) user.setEmail(request.getEmail());

        if (request.getRoles() != null) user.setRoles(resolveRoles(request.getRoles()));
        if (request.getPositions() != null) user.setPositions(resolvePositions(request.getPositions()));

        return UserDto.from(user);
    }

    private Set<Role> resolveRoles(Set<String> roleNames) {
        if (roleNames == null) return Set.of();

        return roleNames.stream()
                .map(name -> roleRepository.findByName(name)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + name)))
                .collect(Collectors.toSet());
    }

    private Set<Position> resolvePositions(Set<String> titles) {
        if (titles == null) return Set.of();
        return titles.stream().map(title ->
                positionRepository.findByTitle(title).orElseGet(() -> positionRepository.save(new Position(title)))
        ).collect(Collectors.toSet());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}

