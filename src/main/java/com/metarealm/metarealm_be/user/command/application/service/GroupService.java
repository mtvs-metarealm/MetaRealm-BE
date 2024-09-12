package com.metarealm.metarealm_be.user.command.application.service;

import com.metarealm.metarealm_be.user.command.domain.aggregate.Group;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupResponseDTO;
import com.metarealm.metarealm_be.user.command.domain.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    //그룹 전체 조회
    public List<GroupResponseDTO> findAllGroup() {

        List<Group> groups = groupRepository.findAll();
        List<GroupResponseDTO> groupResponseDTOs = groups.stream().map(
                dto->new GroupResponseDTO(dto.getGroupName(),dto.getGroupReader())
        ).collect(Collectors.toList());

        return groupResponseDTOs;
    }
}
