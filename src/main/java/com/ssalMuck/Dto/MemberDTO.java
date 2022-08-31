package com.ssalMuck.Dto;

import com.ssalMuck.Entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {
    private String id;
    private String password;
    private String name;


    //Entity binding
    public MemberDTO(Member member){
        this.id = member.getId();
        this.password = member.getPassword();
        this.name = member.getName();

    }
}
