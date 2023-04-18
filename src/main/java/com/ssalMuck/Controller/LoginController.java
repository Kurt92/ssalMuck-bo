package com.ssalMuck.Controller;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Entity.Member;
import com.ssalMuck.cmmn.cookie.CookieUtil;
import com.ssalMuck.cmmn.jwt.JwtUtil;
import com.ssalMuck.cmmn.redis.RedisUtil;
import com.ssalMuck.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {


    private final LoginService loginService;
    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;
    private final RedisUtil redisUtil;


    @ApiOperation(value="로그인", notes="유저를 조회한다")
    @Transactional
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody Member member, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception{

        member = loginService.login(member);
        final String token = jwtUtil.generateToken(member);
        final String refreshJwt = jwtUtil.generateRefreshToken(member);
        Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
        Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);

        log.info("accessToken"+accessToken);
        log.info("refreshToken"+refreshToken);

        redisUtil.setDataExpire(refreshJwt, member.getUser_id(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
        redisUtil.getData(token);

        res.addCookie(accessToken);
        res.addCookie(refreshToken);


        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("list", member);
        //resultMap.put("JWT", accessToken);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpSession session){
        log.info("session check : "+session.getId());
        //세션에 들어있는 값 제거
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value="회원가입", notes="신규 회원가입")
    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody Member member) throws Exception{

        loginService.signin(member);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
