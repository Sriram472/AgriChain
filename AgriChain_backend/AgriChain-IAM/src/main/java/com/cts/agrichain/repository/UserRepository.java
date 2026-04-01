package com.cts.agrichain.repository;

import com.cts.agrichain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUserIdAndStatus(Long userId, User.UserStatus status);

    List<User> findByRole(User.UserRole role);

    List<User> findByStatus(User.UserStatus status);

    boolean existsByEmail(String email);
}

