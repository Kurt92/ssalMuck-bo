package com.ssalMuck.Security.model;

import com.ssalMuck.Entity.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityMember extends User {

    public SecurityMember(Member member){
        super(member.getUsername(),"{noop}"+ member.getPassword(), AuthorityUtils.createAuthorityList(member.getMemberRole().toString()));

    }
}
