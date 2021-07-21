package mr.shtein.SpringSecurityTests.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import lombok.Data;
import mr.shtein.SpringSecurityTests.model.User;

@Data
public class SecurityUser implements UserDetails {
    private final String userName;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    public SecurityUser(String userName, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return  isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive ;
    }

    public static UserDetails fromUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                user.getStatus().equals("ACTIVE"),
                user.getStatus().equals("ACTIVE"),
                user.getStatus().equals("ACTIVE"),
                user.getStatus().equals("ACTIVE"),
                user.getRole().getAuthorities()
        );
    }
}
