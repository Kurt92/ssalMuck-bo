package com.ssalMuck.Repository;

import com.ssalMuck.Entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    //검색
    /*public List<Order> findAll(OrderSearch orderSearch){

        QOrder order = QOrder.order;
        QMember member = QMemeber.member;

        return query
                .select(order)
                .from(order)
                .join(order.memberm, member)
                .where(statusEq(orderSearch.getOrderStatus()),
                        nameLike(orderSearch, getMemberName()))
                .limit(1000)
                .fetch();

    }*/
}
