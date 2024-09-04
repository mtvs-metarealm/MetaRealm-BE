package com.metarealm.metarealm_be.ai.service;

import com.metarealm.metarealm_be.ai.client.AIClient;
import com.metarealm.metarealm_be.ai.dto.AIResponseDto;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final AIClient aiClient;

    @Autowired
    public AIService(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public AIResponseDto getAIResponse() {
        return aiClient.getAIResponse(new File("mp3/baborayo.mp3"));
    }
}