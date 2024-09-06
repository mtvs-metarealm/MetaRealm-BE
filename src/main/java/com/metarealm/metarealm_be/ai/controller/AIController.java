package com.metarealm.metarealm_be.ai.controller;

import com.metarealm.metarealm_be.ai.dto.AITestResponseDto;
import com.metarealm.metarealm_be.ai.service.AIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/ai")
@Slf4j
public class AIController {

    private final AIService aiService;

    @Autowired
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    // 1. 테스트
    @GetMapping("test")
    public AITestResponseDto test() {
        return aiService.test();
    }
}