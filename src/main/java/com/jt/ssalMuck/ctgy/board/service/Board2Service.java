package com.jt.ssalMuck.ctgy.board.service;

import com.jt.ssalMuck.ctgy.board.dto.Board2DTO;
import com.jt.ssalMuck.domain.board.Board2;
import com.jt.ssalMuck.domain.board.Board2Repository;
import com.jt.ssalMuck.ctgy.board.Mapper.Board2Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor

public class Board2Service {

    private final Board2Repository board2Repository;

    @Transactional(readOnly = true)
    public List<Board2> find(){

        List<Board2> boardList = board2Repository.findAll();
        log.info("aaa" + boardList);


        //entity to dto 리턴
        return boardList;
    }

    public Optional<Board2> findBoardDetail(Long id){
        Optional<Board2> board = board2Repository.findById(id);
        return board;
    }

    @Transactional
    public void insert(Board2DTO.save.Request dto){

        Board2 board2 = Board2.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .username(dto.getUsername())
                .build();


        board2Repository.save(board2);
    }

    @Transactional
    public void likeHit(Long id) throws Exception {
        Board2 board2 = board2Repository.findById(id).orElseThrow(()-> new RuntimeException());

        board2.setLikeHit(board2.getLikeHit() + 1);

    }

}
