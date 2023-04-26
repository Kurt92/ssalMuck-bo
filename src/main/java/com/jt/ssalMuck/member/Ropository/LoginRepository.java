package com.jt.ssalMuck.member.Ropository;

import com.jt.ssalMuck.member.Entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Slf4j
public class LoginRepository {

    @PersistenceContext
    private EntityManager em;

    public Member find(Member member) {
        return em.find(Member.class, member.getUser_id());
    }

    public void save(Member member) {
        log.info("aaa"+member);
        em.persist(member);
        em.flush();
    }
}
