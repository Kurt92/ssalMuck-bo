package com.ssalMuck.Repository;

import com.ssalMuck.Entity.Board2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class Board2Repository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Board2 b2){
        em.persist(b2);
        return b2.getId();
    }

    public Board2 findBoard(Long id){
        return em.find(Board2.class, id);
    }

}
