package com.ssalMuck.Entity;

import com.ssalMuck.Security.MemberRole;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Member{

    @Id
    @Column(name = "user_id")
    @ApiParam(value="아이디")
    private String user_id;

    @ApiParam(value="비밀번호")
    private String password;

    @ApiParam(value="이름")
    private String username;

    @ApiParam(value="이메일")
    private String email;

    @Embedded
    @ApiParam(value="주소", hidden = true)
    private Address address;

    @ApiParam(value="사용여부")
    private String useYn;

    @ApiParam(value="멤버롤")
    private MemberRole memberRole;







}
