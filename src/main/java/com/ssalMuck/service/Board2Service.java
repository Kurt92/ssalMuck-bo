package com.ssalMuck.service;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.Entity.Board2;
import com.ssalMuck.Mapper.Board2Mapper;
import com.ssalMuck.Repository.Board2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor

public class Board2Service {

    private final Board2Repository board2Repository;
    private final Board2Mapper board2Mapper;

    @Transactional(readOnly = true)
    public List<Board2DTO> find(){

        //엔티티에 담기
        List<Board2> findAll = board2Repository.findAll();
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

}
