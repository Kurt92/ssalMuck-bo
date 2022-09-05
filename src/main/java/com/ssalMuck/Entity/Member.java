package com.ssalMuck.Entity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jdk.nashorn.internal.runtime.Debug;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @Column(name = "user_id")
    @ApiParam(value = "회원 아이디", required = true, example = "chcch123")
    private String id;

    //@ApiParam(value = "회원 비밀번호", required = true)
    private String password;

    //@ApiParam(value = "회원 이름")
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}
