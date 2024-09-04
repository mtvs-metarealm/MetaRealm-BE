package com.metarealm.metarealm_be.user.command.application.service;

import com.metarealm.metarealm_be.user.command.domain.aggregate.User;
import com.metarealm.metarealm_be.user.command.domain.dto.UserRequestDTO;
import com.metarealm.metarealm_be.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //생성
    @Transactional
    public UserRequestDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userRequestDTO.toEntity();
        user = userRepository.save(user);
        UserRequestDTO dto = user.toEntity(user);
        return dto;
    }
}
