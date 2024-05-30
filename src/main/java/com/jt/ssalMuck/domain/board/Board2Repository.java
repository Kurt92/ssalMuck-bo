package com.jt.ssalMuck.domain.board;

import com.jt.ssalMuck.domain.board.Board2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Board2Repository extends JpaRepository<Board2, Long> {

    Page<Board2> findAllByOrderByCreatedDateDesc(Pageable pageable);

}
