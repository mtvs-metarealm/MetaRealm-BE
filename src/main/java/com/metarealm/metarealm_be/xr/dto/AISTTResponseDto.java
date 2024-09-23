package com.metarealm.metarealm_be.xr.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class AISTTResponseDto {

    private String response;

    @Builder
    public AISTTResponseDto(String response) {
        this.response = response;
    }
}