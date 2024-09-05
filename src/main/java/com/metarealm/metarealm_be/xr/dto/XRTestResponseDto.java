package com.metarealm.metarealm_be.xr.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class XRTestResponseDto {
    String testMessage;

    @Builder
    public XRTestResponseDto(String testMessage) {
        this.testMessage = testMessage;
    }
}