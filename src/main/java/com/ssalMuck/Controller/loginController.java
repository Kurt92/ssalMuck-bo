package com.ssalMuck.Controller;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Entity.Member;
import com.ssalMuck.MemberRepository;
import com.ssalMuck.service.LoginService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class loginController {

    @Autowired LoginService loginService;


    @ApiOperation(value="로그인", notes="유저를 조회한다")
    @Transactional
    @GetMapping("/login.do")
    public ResponseEntity login(@RequestParam("id") String id, @ModelAttribute MemberDTO memberDto,Member member, Model model, HttpSession session){

        log.info("login.do 호출");
        log.info("param check : " + id);
        log.info("param check : " + memberDto.getId());


        memberDto = loginService.login(memberDto);
        session.setAttribute("id",memberDto.getId());
        session.setAttribute("name",memberDto.getName());
        log.info("select result : " + session.getId());
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("list",memberDto);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @GetMapping("/logout.do")
    public ResponseEntity logout(HttpSession session){
        log.info("session check : "+session.getId());
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity signin() {
        return null;
    }

}
