package com.metarealm.metarealm_be.ai.controller;

import com.metarealm.metarealm_be.ai.dto.AIResponseDto;
import com.metarealm.metarealm_be.ai.dto.AiIndexEndPointResponseDto;
import com.metarealm.metarealm_be.ai.service.AIService;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("localhost:8080")
@Slf4j
public class AIController {

    private final AIService aiService;

    @Autowired
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    // 1. 기본 인덱스 엔드 포인트 (테스트용)
    @GetMapping("/v1/ai/test")
    public AiIndexEndPointResponseDto testDefaultIndexEndPoint() {
        AiIndexEndPointResponseDto aiIndexEndPointResponseDto = aiService.testDefaultIndexEndPoint();
        log.info("aiIndexEndPointResponseDto : {}", aiIndexEndPointResponseDto);
        return aiIndexEndPointResponseDto;
    }

    @PostMapping("/v1/ai/stt")
    public AIResponseDto getAIResponse(@RequestParam("audio") MultipartFile multipartFile,
        @RequestHeader HttpHeaders headers) throws IOException {
        return aiService.getAIResponse(multipartFile);
    }
}