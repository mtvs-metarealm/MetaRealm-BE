package com.metarealm.metarealm_be.ai.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AIResponseDto {
    String messages;
}