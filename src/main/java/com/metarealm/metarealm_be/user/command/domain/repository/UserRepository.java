package com.metarealm.metarealm_be.user.command.domain.repository;


import com.metarealm.metarealm_be.user.command.domain.aggregate.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
