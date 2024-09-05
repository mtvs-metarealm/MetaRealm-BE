package com.metarealm.metarealm_be.user;

import com.metarealm.metarealm_be.user.command.application.service.GroupService;
import com.metarealm.metarealm_be.user.command.application.service.UGService;
import com.metarealm.metarealm_be.user.command.application.service.UserService;
import com.metarealm.metarealm_be.user.command.domain.aggregate.Group;
import com.metarealm.metarealm_be.user.command.domain.aggregate.User;
import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroup;
import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroupId;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupFindByIdResponseDTO;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupRequestDTO;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupResponseDTO;
import com.metarealm.metarealm_be.user.command.domain.repository.GroupRepository;
import com.metarealm.metarealm_be.user.command.domain.repository.UGRepository;
import com.metarealm.metarealm_be.user.command.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    private GroupService groupService;

    @DisplayName("회원이 그룹방 생성")
    @Test
    void createGroupRoom () {

        //given
        User user = new User("가즈아","1234");
        user = userRepository.save(user);

        //when
        GroupRequestDTO groupRequestDTO = new GroupRequestDTO("이거맞냐",user.getUserId());
        UserGroup test = ugService.createUG(user.getUserId(),groupRequestDTO);

        //then
    }

    @DisplayName("전체 그룹 조회")
    @Test
    void findAllGroup() {

        //given
        Group test1 = new Group("test1",1L);
        Group test2 = new Group("test2",2L);
        Group test3 = new Group("test3",3L);
        groupRepository.save(test1);
        groupRepository.save(test2);
        groupRepository.save(test3);

        //when
        List<GroupResponseDTO> groups = groupService.findAllGroup();

    }

    @DisplayName("특정 회원이 들어가있는 그룹방 조회")
    @Test
    void findByIdGroupTest() {

        //given
        User user = new User("가즈아","1234");
        user = userRepository.save(user);

        Group test1 = new Group("test1",user.getUserId());
        Group test2 = new Group("test2",user.getUserId());
        Group test3 = new Group("test3",user.getUserId());
        groupRepository.save(test1);
        groupRepository.save(test2);
        groupRepository.save(test3);

        //when
        List<GroupFindByIdResponseDTO> userGroup = ugService.groupfindById(user.getUserId());



    }


}
