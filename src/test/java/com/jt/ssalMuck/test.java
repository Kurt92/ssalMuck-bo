package com.jt.ssalMuck;

import com.jt.ssalMuck.board.Model.Board2DTO;
import com.jt.ssalMuck.member.Model.MemberDTO;
import com.jt.ssalMuck.service.ITest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest

@Slf4j
public class test {

   // @Autowired
    //private SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();

    @Autowired
    public ITest aaa;

    @Test
    public void test1(){

        Board2DTO board2DTO = new Board2DTO();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUsername("aaa");


        board2DTO.setMemberDTO(memberDTO);
        log.info(""+board2DTO);




        Board2DTO board2dto = aaa.findById("2");

    }

}
