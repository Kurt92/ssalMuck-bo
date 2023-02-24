package com.ssalMuck.Controller;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.Entity.Board2;
import com.ssalMuck.Repository.IBoard2Repository;
import com.ssalMuck.service.Board2Service;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    //Spring Data JpaRepository
    private final IBoard2Repository iBoard2Repository;

    @ApiOperation(value="게시판", notes="게시판 전체조회")
    @GetMapping("/board2")
    public ResponseEntity board2 (final Pageable pageable){

        System.out.println(pageable);
        //List<Board2DTO> findAll = board2Service.find(pageable);

        //JpaRepository
        //List<Board2> findAll = iBoard2Repository.findAll();
        Page<Board2> page = iBoard2Repository.findAll(pageable);

        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value="게시판", notes="게시판 상세조회")
    @GetMapping("/board2/Detail")
    public ResponseEntity board2Detail (@RequestParam int id){

        List<Board2DTO> board2Detail = board2Service.findOne(id);

        return new ResponseEntity<>(board2Detail, HttpStatus.OK);
    }



    @ApiOperation(value="게시판", notes="게시판 글쓰기")
    @PostMapping("/board2")
    public ResponseEntity insert (@RequestBody final Board2DTO board2DTO){

        board2Service.insert(board2DTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
