package com.metarealm.metarealm_be.ai.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter // 없으면 406 에러가 생길 수 있음
public class AiIndexEndPointResponseDto {
    String messages;
}
