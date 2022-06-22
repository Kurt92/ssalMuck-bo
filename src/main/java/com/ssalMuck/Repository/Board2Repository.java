package com.ssalMuck.Repository;

import com.ssalMuck.Entity.Board2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Board2Repository {

    @PersistenceContext
    private EntityManager em;

    public int save(Board2 b2){
        em.persist(b2);
        em.flush();
        return b2.getId();
    }

    public Board2 findBoard(int id){
        return em.find(Board2.class, id);
    }
    public List<Board2> findAll(){
        return em.createQuery("select b from Board2 b", Board2.class)
                .setFirstResult(1) // 페이징
                .setMaxResults(10) // 페이징
                .getResultList(); // 리스트 가져오는법
    }

}
