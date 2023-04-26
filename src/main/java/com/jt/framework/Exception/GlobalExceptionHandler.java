package com.jt.framework.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ErrorResponse> handle(NullPointerException e){
        final ErrorResponse response = ErrorResponse.of(ErrorCode.USER_NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * validation binding Error
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(MethodArgumentNotValidException e, BindingResult br){
        ErrorResponse response = null;
        /**
         * BindingResult 의 값을 통해 익셉션 분기
         * brObj = DTO
         * brMsg = @(Massage)
         * */
        String brObj = br.getObjectName();
        String brMsg = br.getFieldError().getDefaultMessage();


        switch (brObj) {
            case "memberDTO" :
                response = ErrorResponse.of(ErrorCode.LOGIN_VAILD, brMsg);
                break;
            case "board2DTO" :
                response = ErrorResponse.of(ErrorCode.BAD_REQUEST, brMsg);
                break;
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
