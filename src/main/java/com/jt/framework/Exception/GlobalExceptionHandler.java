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

        /**
         * BindingResult 의 값을 통해 익셉션 분기
         * brObj = DTO
         * brMsg = @(Massage)
         *
         * DTO 네임을 통해서 분기하려 했으나 이후 확장성에 문제가 생김.(DTO가 추가될때마다 익셉션 헨들러 수정이 필요.)
         * 하여 ErrorCode.BAD_REQUEST로 통일하고 DTO vlidation message를 사용하기만 하면 되기에 수정 진행
         * */
        /*ErrorResponse response = null;
        String brObj = br.getObjectName();
        String brMsg = br.getFieldError().getDefaultMessage();

        switch (brObj) {
            case "memberDTO" :
                response = ErrorResponse.of(ErrorCode.LOGIN_VAILD, brMsg);
                break;
            case "board2DTO" :
                response = ErrorResponse.of(ErrorCode.BAD_REQUEST, brMsg);
                break;
        }*/


        ErrorResponse response = ErrorResponse.of(ErrorCode.BAD_REQUEST, br.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
