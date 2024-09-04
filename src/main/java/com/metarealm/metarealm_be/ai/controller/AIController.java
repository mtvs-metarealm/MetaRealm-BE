package com.metarealm.metarealm_be.ai.controller;

import com.metarealm.metarealm_be.ai.dto.AIResponseDto;
import com.metarealm.metarealm_be.ai.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("localhost:8080")
public class AIController {

    private final AIService aiService;

    @Autowired
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/v1/getAIResponse")
    public AIResponseDto getAIResponse() {
        return aiService.getAIResponse();
    }
}