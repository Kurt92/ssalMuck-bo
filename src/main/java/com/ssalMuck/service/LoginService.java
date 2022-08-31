package com.ssalMuck.service;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Entity.Member;
import com.ssalMuck.Repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public Member login(MemberDTO memberDto){
        log.info("service param id : " + memberDto.getId());
        log.info("service param pass : " + memberDto.getPassword());


        return loginRepository.find(memberDto.getId());
    }
}
