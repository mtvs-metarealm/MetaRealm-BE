package com.metarealm.metarealm_be.exception.handler;

import com.metarealm.metarealm_be.exception.InvalidTokenException;
import com.metarealm.metarealm_be.exception.TokenNotFoundException;
import com.metarealm.metarealm_be.exception.UnexpectedSecurityException;
import com.metarealm.metarealm_be.exception.UserIdAlreadyExistsException;
import com.metarealm.metarealm_be.exception.dto.ErrorResponseDto;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 전역 예외 처리기를 정의하는 클래스입니다. 이 클래스는 애플리케이션 전반에서 발생하는 예외를 처리하고, 적절한 HTTP 응답을 생성합니다.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 회원가입 시 사용자 ID가 이미 존재하는 경우 발생하는 예외를 처리합니다.
     *
     * @param ex 발생한 {@link UserIdAlreadyExistsException} 예외
     * @return {@link ResponseEntity} 객체로, HTTP 상태 코드와 에러 정보를 포함한 응답
     */
    @ExceptionHandler(UserIdAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleUserIdAlreadyExistsException(
        UserIdAlreadyExistsException ex) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
            .errorCategory(HttpStatus.CONFLICT)             // 에러의 포괄적인 타입이나 카테고리
            .httpStatus(HttpStatus.CONFLICT.value())        // HTTP 상태 코드 (enum)
            .customizedStatusCode(101)                      // 팀원끼리 약속한 에러 코드
            .detailErrorDescription(ex.getMessage())        // 구체적인 에러에 대한 설명
            .timestamp(LocalDateTime.now())                 // 발생 시간
            .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDto); // 409 Conflict 응답
    }

    /**
     * 유효하지 않은 토큰이 제공된 경우 발생하는 예외를 처리합니다.
     *
     * @param ex 발생한 {@link InvalidTokenException} 예외
     * @return {@link ResponseEntity} 객체로, HTTP 상태 코드와 에러 정보를 포함한 응답
     */
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidTokenException(InvalidTokenException ex) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
            .errorCategory(HttpStatus.UNAUTHORIZED)          // 에러 카테고리를 명확히 정의
            .httpStatus(HttpStatus.UNAUTHORIZED.value())     // HTTP 상태 코드 (401 Unauthorized)
            .customizedStatusCode(102)                       // 팀원끼리 약속한 에러 코드
            .detailErrorDescription(ex.getMessage())         // 구체적인 에러에 대한 설명
            .timestamp(LocalDateTime.now())                  // 발생 시간
            .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(errorResponseDto); // 401 Unauthorized 응답
    }

    /**
     * 토큰을 찾을 수 없는 경우 발생하는 예외를 처리합니다.
     *
     * @param ex 발생한 {@link TokenNotFoundException} 예외
     * @return {@link ResponseEntity} 객체로, HTTP 상태 코드와 에러 정보를 포함한 응답
     */
    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleTokenNotFoundException(
        TokenNotFoundException ex) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
            .errorCategory(HttpStatus.UNAUTHORIZED)            // 에러 카테고리: 인증 실패
            .httpStatus(HttpStatus.UNAUTHORIZED.value())       // HTTP 상태 코드 (401 Unauthorized)
            .customizedStatusCode(103)                         // 사용자 정의 에러 코드
            .detailErrorDescription(ex.getMessage())           // 구체적인 에러에 대한 설명
            .timestamp(LocalDateTime.now())                    // 발생 시간
            .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED) // 401 Unauthorized 응답
            .body(errorResponseDto);
    }

    /**
     * 예기치 않은 보안 오류가 발생한 경우 발생하는 예외를 처리합니다.
     *
     * @param ex 발생한 {@link UnexpectedSecurityException} 예외
     * @return {@link ResponseEntity} 객체로, HTTP 상태 코드와 에러 정보를 포함한 응답
     */
    @ExceptionHandler(UnexpectedSecurityException.class)
    public ResponseEntity<ErrorResponseDto> handleUnexpectedSecurityException(
        UnexpectedSecurityException ex) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
            .errorCategory(HttpStatus.INTERNAL_SERVER_ERROR)    // 에러 카테고리 정의
            .httpStatus(
                HttpStatus.INTERNAL_SERVER_ERROR.value())       // HTTP 상태 코드 (500 Internal Server Error)
            .customizedStatusCode(104)                          // 사용자 정의 에러 코드 (예시)
            .detailErrorDescription(ex.getMessage())            // 구체적인 에러에 대한 설명
            .timestamp(LocalDateTime.now())                     // 발생 시간
            .build();

        return ResponseEntity.status(
                HttpStatus.INTERNAL_SERVER_ERROR) // 500 Internal Server Error 응답
            .body(errorResponseDto);
    }
}
