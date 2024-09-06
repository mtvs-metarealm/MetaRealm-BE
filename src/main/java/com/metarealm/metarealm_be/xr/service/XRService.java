package com.metarealm.metarealm_be.xr.service;

import com.metarealm.metarealm_be.ai.client.AIClient;
import com.metarealm.metarealm_be.xr.dto.AISTTResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class XRService {

    private final AIClient aiClient;

    public XRService(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public AISTTResponseDto stt(MultipartFile voice) {
        return aiClient.stt(voice);
    }
}