package com.metarealm.metarealm_be.user;

import com.metarealm.metarealm_be.user.command.application.service.UserService;
import com.metarealm.metarealm_be.user.command.domain.dto.UserRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SignUpTest {

    @Autowired
    private UserService userService;

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

}
