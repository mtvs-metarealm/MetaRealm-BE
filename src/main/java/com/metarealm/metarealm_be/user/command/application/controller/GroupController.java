package com.metarealm.metarealm_be.user.command.application.controller;

import com.metarealm.metarealm_be.user.command.application.service.GroupService;
import com.metarealm.metarealm_be.user.command.application.service.UGService;
import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroup;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupFindByIdResponseDTO;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupRequestDTO;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private final UGService ugService;
    private final GroupService groupService;

    public GroupController(UGService ugService, GroupService groupService) {
        this.ugService = ugService;
        this.groupService = groupService;
    }

    //특정 회원이 그룹방생성
    @PostMapping("/{userId}")
    public ResponseEntity<GroupRequestDTO> createGroup(@PathVariable Long userId, @RequestBody GroupRequestDTO groupRequestDTO) {
        UserGroup userGroup = ugService.createUG(userId,groupRequestDTO);
        return ResponseEntity.ok(groupRequestDTO);
    }

    //모든 그룹방 조회
    @GetMapping
    public ResponseEntity<List<GroupResponseDTO>> getAllGroups() {
        List<GroupResponseDTO> groups = groupService.findAllGroup();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<GroupFindByIdResponseDTO>> getGroup(@PathVariable Long userId) {

        List<GroupFindByIdResponseDTO> groupFindByIdResponseDTOS = ugService.groupfindById(userId);
        return ResponseEntity.ok(groupFindByIdResponseDTOS);
    }
}
