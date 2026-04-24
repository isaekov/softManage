package ru.hwru.softmanage.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.hwru.softmanage.entity.Role;
import ru.hwru.softmanage.entity.User;
import ru.hwru.softmanage.repository.RoleRepository;
import ru.hwru.softmanage.repository.UserRepository;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        // Создаём роли, если их нет
        Role adminRole = roleRepository.findByName("ADMIN")
                .orElseGet(() -> roleRepository.save(new Role("ADMIN", "Администратор")));
        Role pmRole = roleRepository.findByName("MANAGER")
                .orElseGet(() -> roleRepository.save(new Role("MANAGER", "Менеджер")));
        Role devRole = roleRepository.findByName("DEVELOPER")
                .orElseGet(() -> roleRepository.save(new Role("DEVELOPER", "Разработчик")));

        Role hrRole = roleRepository.findByName("HR")
                .orElseGet(() -> roleRepository.save(new Role("HR", "HR")));

        Role deRole = roleRepository.findByName("DESIGNER")
                .orElseGet(() -> roleRepository.save(new Role("DESIGNER", "Дизайнер")));


        // Проверяем, есть ли уже главный пользователь
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin")); // пароль
            admin.setEmail("admin@hwru.ru");
            admin.setActive(true);
            admin.setName("Ильдар");
            admin.setLastname("Исаеков");
            admin.getRoles().add(adminRole);

            userRepository.save(admin);

            System.out.println("Главный администратор создан: admin/admin");
        }
    }
}

