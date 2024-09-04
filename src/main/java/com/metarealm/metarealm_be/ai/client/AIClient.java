package com.metarealm.metarealm_be.ai.client;

import com.metarealm.metarealm_be.ai.dto.AIResponseDto;
import java.io.File;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "https://electric-gorgeous-spaniel.ngrok-free.app/stt", name = "AIClient")
public interface AIClient {

    @PostMapping
    AIResponseDto getAIResponse(File files);
}