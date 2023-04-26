package com.jt.ssalMuck.member.Mapper;


import com.jt.ssalMuck.cmmn.util.GenericMapper;
import com.jt.ssalMuck.member.Entity.Member;
import com.jt.ssalMuck.member.Model.MemberDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper extends GenericMapper<MemberDTO, Member> {}
