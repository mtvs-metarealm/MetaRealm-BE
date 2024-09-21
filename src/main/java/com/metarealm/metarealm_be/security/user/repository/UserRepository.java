package com.metarealm.metarealm_be.security.user.repository;

import com.metarealm.metarealm_be.security.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(String id);
    boolean existsByUserId(String userId);
}
