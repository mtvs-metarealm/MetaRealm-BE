package com.metarealm.metarealm_be.user.command.application.service;

import com.metarealm.metarealm_be.user.command.domain.aggregate.Group;
import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroup;
import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroupId;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupFindByIdResponseDTO;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupRequestDTO;
import com.metarealm.metarealm_be.user.command.domain.repository.GroupRepository;
import com.metarealm.metarealm_be.user.command.domain.repository.UGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UGService {


    private final GroupRepository groupRepository;
    private final UGRepository ugRepository;

    public UGService(GroupRepository groupRepository, UGRepository ugRepository) {
        this.groupRepository = groupRepository;
        this.ugRepository = ugRepository;
    }

    //해당 회원이 그룹방 생성
    public UserGroup createUG(Long userId, GroupRequestDTO groupRequestDTO) {

        Group group = groupRequestDTO.toEntity(userId);
        group = groupRepository.save(group);

        UserGroupId userGroup = new UserGroupId(userId,group.getGroupId());
        UserGroup ug = new UserGroup(userGroup);
        return ugRepository.save(ug);

    }

    //해당 회원이 속한 그룹방 조회
    public List<GroupFindByIdResponseDTO> groupfindById(Long userId) {

        List<GroupFindByIdResponseDTO> groupDTOs = ugRepository.findByUserId(userId);

        return groupDTOs;
    }








}
