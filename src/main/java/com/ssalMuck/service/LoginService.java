package com.ssalMuck.service;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Entity.Member;
import com.ssalMuck.Mapper.LoginMapper;
import com.ssalMuck.Repository.IBoard2Repository;
import com.ssalMuck.Repository.ILoginRepository;
import com.ssalMuck.Repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Slf4j

@RequiredArgsConstructor
public class LoginService {

    PasswordEncoder passwordEncoder;

    private final LoginRepository loginRepository;
    private final ILoginRepository iLoginRepository;
    private final LoginMapper loginMapper;

    //생성자 의존주입
    /*@Autowired
    public LoginService(LoginMapper loginMapper){
        this.loginMapper = loginMapper;

    }*/

    @Transactional(readOnly = true)
    public Member login(Member member) throws Exception {
        /*
        //엔티티로 변환
        Member member = loginMapper.toEntity(memberDTO);
        //조회
        member = loginRepository.getById(member.getUser_id());
        //DTO 변환
        memberDTO = loginMapper.toDto(member);
        //엔티티 > DTO (Builder패턴 사용시)
        //memberDTO = memberDTO.toDto(member);
        */


        member = iLoginRepository.findById(member.getUser_id())
                .orElseThrow(()->new IllegalStateException("아이디가 없습니다."));

        return member;

    }

    @Transactional
    public void signin(Member member) throws Exception{

        idCheck(member);
        iLoginRepository.save(member);


    }

    @Transactional
    public void idCheck(Member member) throws Exception{

        iLoginRepository.findById(member.getUser_id())
                .ifPresent( e -> {throw new RuntimeException("이미 있는 아이디임!");});



    }


}
