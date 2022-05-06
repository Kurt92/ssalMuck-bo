package com.ssalMuck.Controller;

import com.ssalMuck.Entity.Board2;
import com.ssalMuck.Repository.Board2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class board2Controller {
    @Autowired Board2Repository board2Repository;

    @Transactional
    @GetMapping("/board2")
    //public Map<String,Object> board2 (Model model){
    public ResponseEntity board2 (Model model){
        System.out.println("board2+++++++++++++++");
        Board2 b2 = new Board2();
        b2.setTitle("aaaaaaaa");
        b2.setUsername("kurt");
        b2.setCreateDT("2022-05-06");




        int saveId = board2Repository.save(b2);
        System.out.println("=====================");
        Map<String,Object> resultMap = new HashMap<String,Object>();

        Board2 findBoard = board2Repository.findBoard(saveId);
        resultMap.put("list",findBoard);
        System.out.println("???????????????? : "+resultMap);

        return new ResponseEntity(resultMap, HttpStatus.OK);
    }
}
