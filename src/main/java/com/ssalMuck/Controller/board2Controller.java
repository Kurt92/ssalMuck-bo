package com.ssalMuck.Controller;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.service.Board2Service;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
public class board2Controller {
    private final Board2Service board2Service;

    @ApiOperation(value="게시판", notes="게시판 전체조회")
    @GetMapping("/board2")
    public ResponseEntity board2 (){

        List<Board2DTO> findAll = board2Service.find();

        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }

    @ApiOperation(value="게시판", notes="게시판 상세조회")
    @GetMapping("/board2/Detail")
    public ResponseEntity board2Detail (@RequestParam int id){

        List<Board2DTO> board2Detail = board2Service.findOne(id);

        return new ResponseEntity<>(board2Detail, HttpStatus.OK);
    }



    @ApiOperation(value="게시판", notes="게시판 글쓰기")
    @PostMapping("/board2")
    public ResponseEntity insert (@RequestBody Board2DTO board2DTO){

        System.out.println("feat_test1");
        System.out.println("fix_test2");


        board2Service.insert(board2DTO);



        return new ResponseEntity<>(HttpStatus.OK);
    }
}
