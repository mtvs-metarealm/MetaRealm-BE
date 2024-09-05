package com.metarealm.metarealm_be.ai.service;

import com.metarealm.metarealm_be.ai.client.AIClient;
import com.metarealm.metarealm_be.ai.dto.AIResponseDto;
import com.metarealm.metarealm_be.ai.dto.AiIndexEndPointResponseDto;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AIService {

    private final AIClient aiClient;

    @Autowired
    public AIService(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public AIResponseDto getAIResponse(MultipartFile multipartFile) throws IOException {
        return aiClient.getAIResponse(multipartFile);
    }

    public AiIndexEndPointResponseDto testDefaultIndexEndPoint() {
        return aiClient.testDefaultIndexEndPoint();
    }
}