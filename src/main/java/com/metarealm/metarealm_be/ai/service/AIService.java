package com.metarealm.metarealm_be.ai.service;

import com.metarealm.metarealm_be.ai.client.AIClient;
import com.metarealm.metarealm_be.ai.dto.AITestResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AIService {

    private final AIClient aiClient;

    @Autowired
    public AIService(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public AITestResponseDto test() {
        return aiClient.test();
    }
}