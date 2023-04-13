package com.ssalMuck.service;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.Entity.Board2;
import com.ssalMuck.Mapper.Board2Mapper;
import com.ssalMuck.Repository.Board2Repository;
import com.ssalMuck.Repository.IBoard2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
        Board2 board2 = board2Mapper.toEntity(board2DTO);
        board2Repository.insert(board2);
    }

    @Transactional
    public Board2 likeHit(Map<String,String> map) throws Exception {

        Board2 board2 = iBoard2Repository.findById(Long.parseLong(map.get("id")))
                .orElseThrow(() -> new NotFoundException("like error"));

        board2.setLikeHit(map.get("count"));

        return board2;







    }

}
