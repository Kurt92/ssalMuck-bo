package com.ssalMuck.Controller;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.Entity.Board2;
import com.ssalMuck.Mapper.Board2Mapper;
import com.ssalMuck.Repository.IBoard2Repository;
import com.ssalMuck.service.Board2Service;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class Board2Controller {
    private final Board2Service board2Service;
    private final Board2Mapper board2Mapper;
    private final IBoard2Repository iBoard2Repository;

    @ApiOperation(value="게시판", notes="게시판 전체조회")
    @GetMapping("/board2")
    public ResponseEntity board2 (final Pageable pageable){

        //System.out.println(pageable);
        //List<Board2DTO> findAll = board2Service.find(pageasdasdasdable);
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("createdDate").descending());

        //JpaRepository
        Page<Board2> page = iBoard2Repository.findAll(sortedPageable);

        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value="게시판", notes="게시판 상세조회")
    @GetMapping("/board2/detail")
    public ResponseEntity board2Detail (@RequestParam(required = false) Long id){

        //List<Board2DTO> board2Detail = board2Service.findOne(id);

        Optional<Board2> board2Detail = iBoard2Repository.findById(id);

        return new ResponseEntity<>(board2Detail, HttpStatus.OK);
    }



    @ApiOperation(value="게시판", notes="게시판 글쓰기")
    @PostMapping("/board2")
    public ResponseEntity insert (@RequestBody final Board2DTO board2DTO){

        Board2 board2 = board2Mapper.toEntity(board2DTO);

        iBoard2Repository.save(board2);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value="좋아요", notes="좋아요 클릭")
    @PostMapping("/board2/detail/hitLike")
    public ResponseEntity hitLike (@RequestBody Map<String, String> map) throws Exception{

        Board2 board2 = new Board2();
        switch(map.get("flag")) {
            case "like":
                board2 = board2Service.likeHit(map);
                break;
            case "dislike":
                break;
        }

        return new ResponseEntity<>(board2,HttpStatus.OK);
    }
}
