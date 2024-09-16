package com.metarealm.metarealm_be.security.user.controller;

import com.metarealm.metarealm_be.exception.UserIdAlreadyExistsException;
import com.metarealm.metarealm_be.security.user.dto.UserRegisterResponseDto;
import com.metarealm.metarealm_be.security.user.entity.User;
import com.metarealm.metarealm_be.security.user.repository.UserRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/signup")
    public ResponseEntity<UserRegisterResponseDto> signup(@RequestBody User user) {

        if (userRepository.existsByUserId(user.getUserId())) {
            throw new UserIdAlreadyExistsException("User ID already exists");
        }

        user.setUserPass(passwordEncoder.encode(user.getUserPass()));
        user.setState("Y");

        User value = userRepository.save(user);

        if (Objects.isNull(value)) {
            UserRegisterResponseDto userRegisterResponseDto = UserRegisterResponseDto.builder()
                .message("Failed to Register")
                .build();
            return ResponseEntity.status(500).body(userRegisterResponseDto);
        } else {
            UserRegisterResponseDto userRegisterResponseDto = UserRegisterResponseDto.builder()
                .message("Successes to register user")
                .build();
            return ResponseEntity.ok(userRegisterResponseDto);
        }
    }
}
