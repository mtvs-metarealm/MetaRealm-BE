package com.metarealm.metarealm_be.user;

import com.metarealm.metarealm_be.user.command.application.service.UGService;
import com.metarealm.metarealm_be.user.command.application.service.UserService;
import com.metarealm.metarealm_be.user.command.domain.aggregate.User;
import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroup;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupRequestDTO;
import com.metarealm.metarealm_be.user.command.domain.repository.GroupRepository;
import com.metarealm.metarealm_be.user.command.domain.repository.UGRepository;
import com.metarealm.metarealm_be.user.command.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UGTest {

    @Autowired
    private UGService ugService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UGRepository ugRepository;

    @Autowired
    private UserService userService;

    @DisplayName("회원이 그룹방 생성")
    @Test
    void createGroupRoom () {

        //given
        User user = new User("가즈아","1234");
        user = userRepository.save(user);

        GroupRequestDTO groupRequestDTO = new GroupRequestDTO("이거맞냐",user.getUserId());

        //when
        UserGroup test = ugService.createUG(user.getUserId(),groupRequestDTO);


        //then
    }

}
