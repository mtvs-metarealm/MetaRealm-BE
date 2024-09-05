package com.metarealm.metarealm_be.xr.controller;

import com.metarealm.metarealm_be.xr.dto.XRTestResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/xr")
public class XRController {

    @GetMapping("/test")
    public XRTestResponseDto testXR() {
        return XRTestResponseDto.builder()
            .testMessage("XR Connection Test")
            .build();
    }
}