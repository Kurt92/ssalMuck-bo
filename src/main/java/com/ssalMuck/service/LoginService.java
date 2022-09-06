package com.ssalMuck.service;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Entity.Member;
import com.ssalMuck.Repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public MemberDTO login(MemberDTO memberDTO){

        //DTO > 엔티티   => ropository 로 옮겼음
        /*Member member = Member.builder(memberDTO).build();*/

        //DTO > 엔티티
        Member member = memberDTO.toEntity();
        member = loginRepository.find(member);
        //dps
        memberDTO = memberDTO.toDto(member);


        return memberDTO;
    }


}
