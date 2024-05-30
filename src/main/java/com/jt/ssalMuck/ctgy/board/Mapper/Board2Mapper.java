package com.jt.ssalMuck.ctgy.board.Mapper;

import com.jt.ssalMuck.cmmn.util.GenericMapper;
import com.jt.ssalMuck.ctgy.board.dto.Board2DTO;
import com.jt.ssalMuck.domain.board.Board2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Board2Mapper extends GenericMapper<Board2DTO, Board2> {}
