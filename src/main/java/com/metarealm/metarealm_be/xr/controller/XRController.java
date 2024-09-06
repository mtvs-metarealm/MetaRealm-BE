package com.metarealm.metarealm_be.xr.controller;

import com.metarealm.metarealm_be.xr.dto.AISTTResponseDto;
import com.metarealm.metarealm_be.xr.dto.XRTestResponseDto;
import com.metarealm.metarealm_be.xr.service.XRService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/xr")
public class XRController {

    private final XRService xrService;

    public XRController(XRService xrService) {
        this.xrService = xrService;
    }

    @GetMapping("/test")
    public XRTestResponseDto testXR() {
        return XRTestResponseDto.builder()
            .testMessage("XR Connection Test")
            .build();
    }

    @PostMapping("/stt")
    public AISTTResponseDto testAudioFiles(MultipartFile voice) {
        return xrService.stt(voice);
    }
}