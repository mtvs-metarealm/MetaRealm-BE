package com.metarealm.metarealm_be.xr.controller;

import com.metarealm.metarealm_be.xr.dto.AISTTResponseDto;
import com.metarealm.metarealm_be.xr.dto.XRTestResponseDto;
import com.metarealm.metarealm_be.xr.service.XRService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/xr")
@Slf4j
public class XRController {

    private final XRService xrService;

    public XRController(XRService xrService) {
        this.xrService = xrService;
    }

    @GetMapping("/test")
    public ResponseEntity<XRTestResponseDto> testXR() {
        log.info("XR 테스트 메서드 호출");
        XRTestResponseDto xrTestResponseDto = XRTestResponseDto.builder()
            .testMessage("XR Connection Test")
            .build();
        return new ResponseEntity<>(xrTestResponseDto, HttpStatus.OK);
    }

    @PostMapping("/stt")
    public AISTTResponseDto testAudioFiles(MultipartFile voice) {
        AISTTResponseDto aisttResponseDto = xrService.stt(voice);
        log.info("XR이 STT 메서드 호출\nAISTTResponseDto : {}", aisttResponseDto.toString());
        return aisttResponseDto;
    }
}