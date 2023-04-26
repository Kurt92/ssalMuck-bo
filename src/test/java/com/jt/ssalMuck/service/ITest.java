package com.jt.ssalMuck.service;

import com.jt.ssalMuck.board.Model.Board2DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ITest {

    @Select("select * from board2 where title = #{title}")
    public Board2DTO findById(String title);


}
