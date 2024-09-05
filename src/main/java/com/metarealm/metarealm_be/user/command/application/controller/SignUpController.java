package com.metarealm.metarealm_be.user.command.application.controller;

import com.metarealm.metarealm_be.user.command.application.service.UserService;
import com.metarealm.metarealm_be.user.command.domain.aggregate.User;
import com.metarealm.metarealm_be.user.command.domain.dto.UserRequestDTO;
import com.metarealm.metarealm_be.user.command.domain.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {


    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    //회원가입
    @PostMapping
    public ResponseEntity<UserRequestDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
        UserRequestDTO createUser = userService.createUser(userRequestDTO);
        return ResponseEntity.ok(createUser);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        List<UserResponseDTO> userResponseDTOS = userService.findAllUser();
        return ResponseEntity.ok(userResponseDTOS);
    }




}
