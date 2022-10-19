package com.ssalMuck.Entity;

import com.ssalMuck.Dto.MemberDTO;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Member{

    @Id
    @Column(name = "user_id")
    private String id;

    private String password;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();





}
