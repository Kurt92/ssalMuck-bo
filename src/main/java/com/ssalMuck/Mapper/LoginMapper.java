package com.ssalMuck.Mapper;


import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Entity.Member;
import com.ssalMuck.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper extends GenericMapper<MemberDTO, Member> {}
