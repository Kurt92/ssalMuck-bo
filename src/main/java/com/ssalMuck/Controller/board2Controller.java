package com.ssalMuck.Controller;

import com.ssalMuck.Entity.Board2;
import com.ssalMuck.Repository.Board2Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class board2Controller {
    @Autowired Board2Repository board2Repository;

    @Transactional
    @GetMapping("/board2.do")
    //public Map<String,Object> board2 (Model model){
    public ResponseEntity board2 (Model model){

        Map<String,Object> resultMap = new HashMap<String,Object>();

        List findAll = board2Repository.findAll();
        resultMap.put("list",findAll);
        System.out.println(resultMap);

        resultMap.forEach((key,value)->{
            System.out.println(key+ " : " + value);

        });


        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}
