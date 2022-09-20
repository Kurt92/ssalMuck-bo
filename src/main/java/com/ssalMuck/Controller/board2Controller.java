package com.ssalMuck.Controller;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.Entity.Board2;
import com.ssalMuck.Repository.Board2Repository;
import com.ssalMuck.service.Board2Service;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class board2Controller {
    @Autowired Board2Service board2Service;

    @ApiOperation(value="게시판", notes="게시판 전체조회")
    @GetMapping("/board2")
    public ResponseEntity board2 (){

        List<Board2DTO> findAll = board2Service.find();

        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }

    @ApiOperation(value="게시판", notes="게시판 글쓰기")
    @PostMapping("/board2")
    public ResponseEntity insert (@ModelAttribute Board2DTO board2DTO){


        board2Service.insert(board2DTO);


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
