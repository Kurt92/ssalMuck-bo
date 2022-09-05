package com.ssalMuck.Dto;

import com.ssalMuck.Entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class MemberDTO {
    private String id;
    private String password;
    private String name;


    //Entity binding builder
    public Member toEntity() {
        return Member.builder()
                .id(id)
                .password(password)
                .name(name)
                .build();
    }
}
