package com.metarealm.metarealm_be.ai.client;

import com.metarealm.metarealm_be.ai.dto.AIResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(url = "https://electric-gorgeous-spaniel.ngrok-free.app", name = "AIClient")
public interface AIClient {

    @PostMapping(value = "/stt")
    AIResponseDto getAIResponse(@RequestPart("audio") MultipartFile multipartFile);
}