package com.jt.ssalMuck.board.repository;

import com.jt.ssalMuck.board.Entity.Board2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBoard2Repository extends JpaRepository<Board2, Long> {

    Page<Board2> findAllByOrderByCreatedDateDesc(Pageable pageable);

}
