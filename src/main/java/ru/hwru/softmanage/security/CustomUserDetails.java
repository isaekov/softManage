package ru.hwru.softmanage.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.hwru.softmanage.entity.User;


import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    // --- Методы UserDetails ---

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Если у вас есть роли — добавьте их здесь
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    @Override
    public boolean isEnabled() { return true; }

    // --- ДОПОЛНИТЕЛЬНЫЕ ПОЛЯ (для Thymeleaf) ---

    public String getEmail() {
        return user.getEmail();
    }

    public String getFullName() {
        return user.getName();
    }

    // Опционально: чтобы получить исходный объект User
    public User getUser() {
        return user;
    }
}
