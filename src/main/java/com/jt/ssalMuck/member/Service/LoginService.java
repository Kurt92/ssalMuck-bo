package com.jt.ssalMuck.member.Service;

import com.jt.ssalMuck.member.Entity.Member;
import com.jt.ssalMuck.member.Mapper.LoginMapper;
import com.jt.ssalMuck.member.Model.MemberDTO;
import com.jt.ssalMuck.member.Ropository.ILoginRepository;
import com.jt.ssalMuck.member.Ropository.LoginRepository;
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

    private final LoginRepository loginRepository;
    private final ILoginRepository iLoginRepository;
    private final LoginMapper loginMapper;


    @Transactional(readOnly = true)
    public MemberDTO login(MemberDTO memberDto) throws Exception {

        //엔티티로 변환
        Member member = loginMapper.toEntity(memberDto);
        //조회
        member = iLoginRepository.findById(member.getUser_id())
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

        iLoginRepository.findById(member.getUser_id())
                .ifPresent( e -> {throw new RuntimeException("이미 있는 아이디임!");});



    }


}
