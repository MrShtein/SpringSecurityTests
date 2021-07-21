package mr.shtein.SpringSecurityTests.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import mr.shtein.SpringSecurityTests.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
