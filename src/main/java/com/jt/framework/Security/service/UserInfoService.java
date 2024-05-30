package com.jt.framework.Security.service;

import com.jt.framework.Security.repository.IUserInfoRepository;
import com.jt.ssalMuck.domain.member.Member;
import com.jt.framework.Security.model.SecurityMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//커스텀필터에서 호출할 서비스
@Service
public class UserInfoService implements UserDetailsService {


    private IUserInfoRepository iUserInfoRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = iUserInfoRepository.findByUsername(username);
        if(member == null){
            throw new UsernameNotFoundException(username + " : 사용자 존재하지 않음");
        }
        return new SecurityMember(member);
    }
}
