package com.ssalMuck.service;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Entity.Member;
import com.ssalMuck.Mapper.LoginMapper;
import com.ssalMuck.Repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j

@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;
    private final LoginMapper loginMapper;

    //생성자 의존주입
    /*@Autowired
    public LoginService(LoginMapper loginMapper){
        this.loginMapper = loginMapper;

    }*/

    @Transactional(readOnly = true)
    public MemberDTO login(MemberDTO memberDTO){



        //DTO > 엔티티 (Builder패턴 사용시)
        //Member member = memberDTO.toEntity();

        //의존성 주입 없이 사용하기위한 생성자
        //LoginMapper loginMapper = new LoginMapperImpl();

        //MapStruct
        //엔티티로 변환
        Member member = loginMapper.toEntity(memberDTO);
        //조회
        member = loginRepository.find(member);
        //DTO 변환
        memberDTO = loginMapper.toDto(member);



        //엔티티 > DTO (Builder패턴 사용시)
        //memberDTO = memberDTO.toDto(member);


        return memberDTO;
    }

    @Transactional
    public void signin(MemberDTO memberDTO){

        Member member = loginMapper.toEntity(memberDTO);
        loginRepository.save(member);


    }


}
