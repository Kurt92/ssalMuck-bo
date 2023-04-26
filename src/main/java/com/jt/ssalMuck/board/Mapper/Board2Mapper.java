package com.jt.ssalMuck.board.Mapper;

import com.jt.ssalMuck.cmmn.util.GenericMapper;
import com.jt.ssalMuck.board.Entity.Board2;
import com.jt.ssalMuck.board.Model.Board2DTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Board2Mapper extends GenericMapper<Board2DTO, Board2> {}
