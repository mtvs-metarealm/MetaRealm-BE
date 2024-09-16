package com.metarealm.metarealm_be.security.user.controller;

import com.metarealm.metarealm_be.security.user.dto.UserTokenValidationResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasAuthority('USER')")
@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<UserTokenValidationResponseDto> test(){
        UserTokenValidationResponseDto userTokenValidationResponseDto = UserTokenValidationResponseDto.builder()
            .message("It's Valid Token")
            .build();
        return ResponseEntity.ok(userTokenValidationResponseDto);
    }

    @PostMapping("/test")
    public String test2(){
        return "test";
    }
}
