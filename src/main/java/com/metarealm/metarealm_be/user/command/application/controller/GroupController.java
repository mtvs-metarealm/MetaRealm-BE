package com.metarealm.metarealm_be.user.command.application.controller;

import com.metarealm.metarealm_be.user.command.application.service.UGService;
import com.metarealm.metarealm_be.user.command.domain.aggregate.UserGroup;
import com.metarealm.metarealm_be.user.command.domain.dto.GroupRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private final UGService ugService;

    public GroupController(UGService ugService) {
        this.ugService = ugService;
    }

    //특정 회원이 그룹방생성
    @PostMapping("/{userId}")
    public ResponseEntity<GroupRequestDTO> createGroup(@PathVariable Long userId, @RequestBody GroupRequestDTO groupRequestDTO) {
        UserGroup userGroup = ugService.createUG(userId,groupRequestDTO);
        return ResponseEntity.ok(groupRequestDTO);
    }
}
