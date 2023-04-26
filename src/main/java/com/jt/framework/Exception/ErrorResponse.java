package com.jt.framework.Exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.List;

@Slf4j
@Getter
@Builder
public class ErrorResponse {

    private String message;
    private int status;
    private String error;
    private String code;



    public static ErrorResponse of(ErrorCode errorCode) {
        ErrorResponse errorResponse = getErrorResponse(errorCode);
        printErrorResponse(errorResponse);

        return errorResponse;
    }

    public static ErrorResponse of(ErrorCode errorCode, String message) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.name())
                .code(errorCode.name())
                .message(message)
                .build();
        printErrorResponse(errorResponse);

        return errorResponse;
    }



    public static ErrorResponse getErrorResponse(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .status(errorCode.getHttpStatus().value())
                .error(errorCode.getHttpStatus().name())
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }



    private static void printErrorResponse(ErrorResponse errorResponse) {
        log.error("##############################################################################################");
        log.error("{}", errorResponse.getMessage());
        log.error("{}", errorResponse);
        log.error("##############################################################################################");
    }
}
