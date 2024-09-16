package com.metarealm.metarealm_be.exception.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorResponseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private final LocalDateTime timestamp;          // 발생 시간
    private final HttpStatus errorCategory;         // 에러의 포괄적인 타입이나 카테고리
    private final Integer httpStatus;               // HTTP 상태 코드 (enum)
    private final Integer customizedStatusCode;     // 팀원끼리 약속한 에러 코드
    private final String detailErrorDescription;    // 구체적인 에러에 대한 설명
}