package com.ssalMuck.Repository;

import com.ssalMuck.Entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Repository = 컴포넌트 스캔을 해서 spring bean 으로 자동 등록
@Repository
@RequiredArgsConstructor    //@RequiredArgsConstructor = 생성자로 AutoWired lombok
public class MemberRepository {

    //@PersistenceContext = 스프링이 엔티티 매니저를 주입해줌
    /*@PersistenceContext
    private EntityManager em;*/


    //@Autowired => spring data jpa가 autoWired를 지원해줌
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(String id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        //JPQL의 from 대상은 엔티티임
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}
