package com.metarealm.metarealm_be.group.controller;

import com.metarealm.metarealm_be.group.dto.GroupInviteDTO;
import com.metarealm.metarealm_be.group.dto.GroupRequestDTO;
import com.metarealm.metarealm_be.group.dto.GroupSelectDTO;
import com.metarealm.metarealm_be.group.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    @Operation(summary = "새로운 그룹생성")
    public ResponseEntity<GroupRequestDTO> createGroup(@RequestBody GroupRequestDTO groupRequestDTO) {
        GroupRequestDTO group = groupService.createGroup(groupRequestDTO);
        return ResponseEntity.ok(group);
    }

    @PostMapping("/invite")
    @Operation(summary = "그룹방에 초대")
    public ResponseEntity<List<GroupInviteDTO>> inviteGroup(@RequestBody List<GroupInviteDTO> groupInviteDTO) {
        List<GroupInviteDTO> groupInviteDTOS = groupService.inviteUser(groupInviteDTO);
        return ResponseEntity.ok(groupInviteDTOS);
    }

    @GetMapping("/{userNo}")
    @Operation(summary = "해당 유저가 속한 그룹들 조회")
    public ResponseEntity<List<GroupSelectDTO>> selectGroup(@PathVariable Long userNo) {
        List<GroupSelectDTO> groups = groupService.findGroupsByUserNo(userNo);
        return ResponseEntity.ok(groups);
    }



}
