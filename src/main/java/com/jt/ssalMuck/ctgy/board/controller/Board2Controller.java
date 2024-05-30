package com.jt.ssalMuck.ctgy.board.controller;

import com.jt.ssalMuck.ctgy.board.dto.Board2DTO;
import com.jt.ssalMuck.ctgy.board.service.Board2Service;
import com.jt.ssalMuck.domain.board.Board2Repository;
import com.jt.ssalMuck.domain.board.Board2;
import com.jt.ssalMuck.ctgy.board.Mapper.Board2Mapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class Board2Controller {
    private final Board2Service board2Service;

    @ApiOperation(value="게시판", notes="게시판 전체조회")
    @GetMapping("/board2")
    public ResponseEntity board2 (final Pageable pageable){

        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("createdDate").descending());
        List<Board2> page = board2Service.find();

        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value="게시판", notes="게시판 상세조회")
    @GetMapping("/board2/detail")
    public ResponseEntity board2Detail (@RequestParam(required = false) Long id){
        return new ResponseEntity<>(board2Service.findBoardDetail(id), HttpStatus.OK);
    }



    @ApiOperation(value="게시판", notes="게시판 글쓰기")
    @PostMapping("/board2")
    public ResponseEntity insert (@Validated @RequestBody Board2DTO.save.Request board2DTO){
        board2Service.insert(board2DTO);

        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @ApiOperation(value="좋아요", notes="좋아요 클릭")
    @PostMapping("/board2/detail/hitLike")
    public ResponseEntity hitLike (@RequestBody Board2DTO.save.Request board2DTO) throws Exception{


        switch(board2DTO.getFlag()) {
            case "like":
                board2Service.likeHit(board2DTO.getId());
                break;
            case "dislike":
                break;
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
