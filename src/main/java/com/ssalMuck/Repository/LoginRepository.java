package com.ssalMuck.Repository;

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

    public Member find(String id) {
        log.info("Repository Param check : " + id);
        return em.find(Member.class, id);
    }
}
