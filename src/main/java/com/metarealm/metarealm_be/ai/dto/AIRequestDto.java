package com.metarealm.metarealm_be.ai.dto;

import java.io.File;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AIRequestDto {
    File voice;
}