package com.metarealm.metarealm_be.xr.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class AISTTResponseDto {

    private String messages;

    @Builder
    public AISTTResponseDto(String messages) {
        this.messages = messages;
    }
}