package ru.kpfu.test_oris26_04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.test_oris26_04.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
   Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByActivationToken(String token);
}
