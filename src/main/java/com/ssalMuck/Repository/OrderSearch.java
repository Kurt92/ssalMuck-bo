package com.ssalMuck.Repository;

import com.ssalMuck.Entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;


@Getter @Setter
public class OrderSearch {

    private String memberName; //회원이름
    private OrderStatus orderStatus; //주문상태

}
