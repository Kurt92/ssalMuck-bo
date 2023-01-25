package com.ssalMuck.Repository;

import com.ssalMuck.Entity.Board2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Slf4j
public class Board2Repository {

    @PersistenceContext
    private EntityManager em;

    public void insert(Board2 board2){
        em.persist(board2);
        em.flush();
    }

    public List<Board2> findAll(Pageable pageable){
        return em.createQuery("select b from Board2 b", Board2.class)
                .setFirstResult(pageable.getPageNumber()* pageable.getPageSize()) // 페이징
                .setMaxResults(pageable.getPageSize()) // 페이징
                .getResultList(); // 리스트 가져오는법
    }

    public List<Board2> findOne(int id) {
        return em.createQuery("select b from Board2 b where b.id = :id", Board2.class)
                .setParameter("id",id)
                .getResultList(); // 리스트 가져오는법
    }
}
