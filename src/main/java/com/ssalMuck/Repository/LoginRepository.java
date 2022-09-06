package com.ssalMuck.Repository;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Entity.Member;
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
        return em.find(Member.class, member.getId());
    }
}
