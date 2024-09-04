package com.metarealm.metarealm_be.ai.controller;

import com.metarealm.metarealm_be.ai.dto.AIResponseDto;
import com.metarealm.metarealm_be.ai.service.AIService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("localhost:8080")
public class AIController {

    private final AIService aiService;

    @Autowired
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/v1/getAIResponse")
    public AIResponseDto getAIResponse(@RequestParam("audio") MultipartFile multipartFile,
        @RequestHeader HttpHeaders headers) throws IOException {
        return aiService.getAIResponse(multipartFile);
    }
}