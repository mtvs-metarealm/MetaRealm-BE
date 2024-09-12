package com.metarealm.metarealm_be.user;

import com.metarealm.metarealm_be.user.command.application.service.UserService;
import com.metarealm.metarealm_be.user.command.domain.aggregate.User;
import com.metarealm.metarealm_be.user.command.domain.dto.UserRequestDTO;
import com.metarealm.metarealm_be.user.command.domain.dto.UserResponseDTO;
import com.metarealm.metarealm_be.user.command.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SignUpTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @DisplayName("회원가입")
    @Test
    void signup() {
        //given
        UserRequestDTO req = new UserRequestDTO("user1234","pass1234");

        //when
        UserRequestDTO createUser = userService.createUser(req);

        //then
        assertThat(createUser.getUserName()).isEqualTo("user1234");
        assertThat(createUser.getUserPass()).isEqualTo("pass1234");
    }

    @DisplayName("모든 회원 조회")
    @Test
    void findAllUserTest() {

        //given
        User user1 = new User("김김김","pass1234");
        User user2 = new User("손손손","pass1234");
        User user3 = new User("채채채","pass1234");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //when
        List<UserResponseDTO> find = userService.findAllUser();

    }


}
