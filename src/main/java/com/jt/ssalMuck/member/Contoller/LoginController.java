package com.jt.ssalMuck.member.Contoller;

import com.jt.framework.util.jwt.JwtUtil;
import com.jt.ssalMuck.member.Entity.Member;
import com.jt.framework.util.cookie.CookieUtil;
import com.jt.framework.util.redis.RedisUtil;
import com.jt.ssalMuck.member.Model.MemberDTO;
import com.jt.ssalMuck.member.Service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity login(@Validated @RequestBody MemberDTO memberDto, HttpServletRequest req, HttpServletResponse res, BindingResult br) throws Exception{

        memberDto = loginService.login(memberDto);
        final String token = jwtUtil.generateToken(memberDto);
        final String refreshJwt = jwtUtil.generateRefreshToken(memberDto);
        Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
        Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);

        log.info("accessToken"+accessToken);
        log.info("refreshToken"+refreshToken);

        redisUtil.setDataExpire(refreshJwt, memberDto.getUser_id(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
        redisUtil.getData(token);

        res.addCookie(accessToken);
        res.addCookie(refreshToken);


        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("list", memberDto);
        resultMap.put("JWT", accessToken);
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
