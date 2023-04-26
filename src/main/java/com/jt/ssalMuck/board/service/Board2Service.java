package com.jt.ssalMuck.board.service;

import com.jt.ssalMuck.board.Model.Board2DTO;
import com.jt.ssalMuck.board.Entity.Board2;
import com.jt.ssalMuck.board.repository.IBoard2Repository;
import com.jt.ssalMuck.board.Mapper.Board2Mapper;
import com.jt.ssalMuck.board.repository.Board2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor

public class Board2Service {

    private final Board2Repository board2Repository;
    private final IBoard2Repository iBoard2Repository;
    private final Board2Mapper board2Mapper;

    @Transactional(readOnly = true)
    public List<Board2DTO> find(Pageable pageable){

        //엔티티에 담기
        List<Board2> findAll = board2Repository.findAll(pageable);
        log.info("aaa" + findAll);

        //entity to dto 리턴
        return board2Mapper.toDtoList(findAll);
    }

    public List<Board2DTO> findOne(int id){
        List<Board2> findOne = board2Repository.findOne(id);
        return board2Mapper.toDtoList(findOne);
    }

    @Transactional
    public void insert(Board2DTO board2DTO){
        //dto -> entity
        Board2 board2 = board2Mapper.toEntity(board2DTO);

        iBoard2Repository.save(board2);
    }

    @Transactional
    public Board2 likeHit(Map<String,String> map) throws Exception {

        Board2 board2 = iBoard2Repository.findById(Long.parseLong(map.get("id")))
                .orElseThrow(() -> new NotFoundException("like error"));

        board2.setLikeHit(map.get("count"));

        return board2;







    }

}
