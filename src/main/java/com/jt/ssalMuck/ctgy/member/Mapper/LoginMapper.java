package com.jt.ssalMuck.ctgy.member.Mapper;


import com.jt.ssalMuck.cmmn.util.GenericMapper;
import com.jt.ssalMuck.domain.member.Member;
import com.jt.ssalMuck.ctgy.member.dto.MemberDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper extends GenericMapper<MemberDTO, Member> {}
