package com.jt.framework.Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    /**
     * 200 : OK, 요청 정상 처리
     * 201 : Created, 생성 요청 성공
     * 202 : Accepted, 비동기 요청 성공
     * 204 : No Content, 요청 정상 처리, 응답 데이터 없음.
     *
     * 실패
     * 400 : Bad Request, 요청이 부적절 할 때, 유효성 검증 실패, 필수 값 누락 등.
     * 401 : Unauthorized, 인증 실패, 로그인하지 않은 사용자 또는 권한 없는 사용자 처리
     * 402 : Payment Required
     * 403 : Forbidden, 인증 성공 그러나 자원에 대한 권한 없음. 삭제, 수정시 권한 없음.
     * 404 : Not Found, 요청한 URI에 대한 리소스 없을 때 사용.
     * 405 : Method Not Allowed, 사용 불가능한 Method를 이용한 경우.
     * 406 : Not Acceptable, 요청된 리소스의 미디어 타입을 제공하지 못할 때 사용.
     * 408 : Request Timeout
     * 409 : Conflict, 리소스 상태에 위반되는 행위 시 사용.
     * 413 : Payload Too Large
     * 423 : Locked
     * 428 : Precondition Required
     * 429 : Too Many Requests
     * 500 : 서버 에러
     */




    // Common
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "요청 매개변수 오류 입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자 정보를 찾을 수 없습니다"),

    //Login
    LOGIN_VAILD(HttpStatus.UNAUTHORIZED, "로그인 오류"),



    //TOKEN
    NOT_EXISTS_TOKEN(HttpStatus.UNAUTHORIZED, "인증된 토큰이 없습니다"),
    NOT_EXISTS_SAVED_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "저장된 인증 토큰이 없습니다"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효한 토큰이 아닙니다"),
    INVALID_ROLE_TOKEN(HttpStatus.UNAUTHORIZED, "사용 권한이 없는 토큰 입니다"),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "토큰 유효기간이 경과 되었습니다"),
    INVALID_SIGN_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 서명의 토큰 입니다"),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "리프레시 토큰이 유효하지 않습니다"),
    MISMATCH_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "리프레시 토큰의 유저 정보가 일치하지 않습니다"),
    MISMATCH_REFRESH_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "발급된 refresh token의 정보가 일치하지 않습니다"),
    NOT_EXPIRED_TOKEN_YET(HttpStatus.UNAUTHORIZED, "토큰 유효기간이 경과되지 않았습니다"),
    ;


    private HttpStatus httpStatus;
    private String message;


    ErrorCode(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }

    ErrorCode(String message){
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.message = message;
    }

}
