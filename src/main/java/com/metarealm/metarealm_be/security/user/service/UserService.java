package com.metarealm.metarealm_be.security.user.service;

import com.metarealm.metarealm_be.security.user.entity.User;
import com.metarealm.metarealm_be.security.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String id) {
        return userRepository.findByUserId(id);
    }
}
