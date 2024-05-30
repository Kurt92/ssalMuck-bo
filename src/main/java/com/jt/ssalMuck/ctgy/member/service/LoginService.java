package com.jt.ssalMuck.ctgy.member.service;

import com.jt.ssalMuck.domain.member.Member;
import com.jt.ssalMuck.ctgy.member.Mapper.LoginMapper;
import com.jt.ssalMuck.domain.member.MemberRepository;
import com.jt.ssalMuck.ctgy.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j

@RequiredArgsConstructor
public class LoginService {

    PasswordEncoder passwordEncoder;

//    private final LoginRepository loginRepository;
    private final MemberRepository iLoginRepository;
    private final LoginMapper loginMapper;


    @Transactional(readOnly = true)
    public MemberDTO login(MemberDTO memberDto) throws Exception {

        //엔티티로 변환
        Member member = loginMapper.toEntity(memberDto);
        //조회
        member = iLoginRepository.findByUserIdAndPassword(member.getUserId(), member.getPassword())
                .orElseThrow(()->new NullPointerException("잉? 이아이디 없음!"));

        //DTO 변환
        memberDto = loginMapper.toDto(member);

        return memberDto;

    }

    @Transactional
    public void signin(Member member) throws Exception{

        idCheck(member);
        iLoginRepository.save(member);


    }

    @Transactional
    public void idCheck(Member member) throws Exception{

        iLoginRepository.findById(member.getUserId())
                .ifPresent( e -> {throw new RuntimeException("이미 있는 아이디임!");});



    }


}
