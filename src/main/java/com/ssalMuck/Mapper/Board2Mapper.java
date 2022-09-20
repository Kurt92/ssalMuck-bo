package com.ssalMuck.Mapper;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.Entity.Board2;
import com.ssalMuck.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Board2Mapper extends GenericMapper<Board2DTO, Board2> {}
