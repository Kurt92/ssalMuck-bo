package com.ssalMuck.Controller;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {


    private final LoginService loginService;


    @ApiOperation(value="로그인", notes="유저를 조회한다")
    @Transactional
    @PostMapping("/login")
    public ResponseEntity login(@ModelAttribute MemberDTO memberDto, HttpSession session){

        memberDto = loginService.login(memberDto);

        session.setAttribute("id",memberDto.getUser_id());
        session.setAttribute("name",memberDto.getName());

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("list", memberDto);
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
    public ResponseEntity signin(@ModelAttribute MemberDTO memberDTO) {
        loginService.signin(memberDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
