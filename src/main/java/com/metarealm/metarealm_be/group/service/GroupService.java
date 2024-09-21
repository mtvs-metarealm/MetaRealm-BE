package com.metarealm.metarealm_be.group.service;

import com.metarealm.metarealm_be.group.aggregate.Group;
import com.metarealm.metarealm_be.group.dto.GroupInviteDTO;
import com.metarealm.metarealm_be.group.dto.GroupRequestDTO;
import com.metarealm.metarealm_be.group.dto.GroupSelectDTO;
import com.metarealm.metarealm_be.group.repository.GroupRepository;
import com.metarealm.metarealm_be.user_group.aggregate.UserGroup;
import com.metarealm.metarealm_be.user_group.repository.UserGroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserGroupRepository userGroupRepository;

    public GroupService(GroupRepository groupRepository, UserGroupRepository userGroupRepository) {
        this.groupRepository = groupRepository;
        this.userGroupRepository = userGroupRepository;
    }

    //그룹생성
    @Transactional
    public GroupRequestDTO createGroup(GroupRequestDTO groupRequestDTO) {

        Group group = new Group();
        group.toEntity(groupRequestDTO.getGroupName(),groupRequestDTO.getIsGroupActive());
        groupRepository.save(group);

        Long id = groupRepository.findByGroupId(group);

        UserGroup userGroup = new UserGroup();
        userGroup.toEntity(userGroup.getUserNo(),id,userGroup.getIsInGroup());
        userGroupRepository.save(userGroup);

        return groupRequestDTO;
    }

    //아이디로 초대
    @Transactional
    public List<GroupInviteDTO> inviteUser(List<GroupInviteDTO> groupInviteDTO) {
        List<UserGroup> userGroups = new ArrayList<>();

        for (GroupInviteDTO groupInviteDTO1 : groupInviteDTO) {
            UserGroup userGroup = new UserGroup();
            userGroup.fromDTO(groupInviteDTO1.getUserNo(), groupInviteDTO1.getGroupId(), 1);

            userGroups.add(userGroup);
        }

        userGroupRepository.saveAll(userGroups);

        return groupInviteDTO;
    }

    //아이디로 조회
    public List<GroupSelectDTO> findGroupsByUserNo(Long userNo) {

        List<Group> activeGroups = userGroupRepository.findActiveGroupsByUserNo(userNo);

        return activeGroups.stream()
                .map(group-> new GroupSelectDTO(group.getGroupId(),group.getGroupName()))
                .collect(Collectors.toList());
    }
}
