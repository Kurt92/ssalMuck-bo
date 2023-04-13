package com.ssalMuck.Repository;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.Entity.Board2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBoard2Repository extends JpaRepository<Board2, Long> {

    Page<Board2> findAllByOrderByCreatedDateDesc(Pageable pageable);

}
