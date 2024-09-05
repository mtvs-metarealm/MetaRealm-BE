package com.metarealm.metarealm_be.user.command.application.service;

import com.metarealm.metarealm_be.user.command.domain.aggregate.User;
import com.metarealm.metarealm_be.user.command.domain.dto.UserRequestDTO;
import com.metarealm.metarealm_be.user.command.domain.dto.UserResponseDTO;
import com.metarealm.metarealm_be.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //생성
    public UserRequestDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userRequestDTO.toEntity();
        user = userRepository.save(user);
        UserRequestDTO dto = user.toEntity(user);
        return dto;
    }

    //모든 유저 조회
    public List<UserResponseDTO> findAllUser() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> dtos = users.stream().map(
                user -> new UserResponseDTO(user.getUserId(),user.getUserName(),user.getUserPass())
        ).toList();
        return dtos;
    }




}
