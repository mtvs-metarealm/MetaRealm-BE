package com.metarealm.metarealm_be.ai.client;

import com.metarealm.metarealm_be.ai.dto.AITestResponseDto;
import com.metarealm.metarealm_be.xr.dto.AISTTResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(url = "https://electric-gorgeous-spaniel.ngrok-free.app", name = "AIClient")
public interface AIClient {

    @GetMapping(value = "/")
    AITestResponseDto test();

    @PostMapping(value = "/stt-chat", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    AISTTResponseDto stt(@RequestPart("voice") MultipartFile voice);
}