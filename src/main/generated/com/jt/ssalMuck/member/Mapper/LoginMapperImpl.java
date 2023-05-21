package com.jt.ssalMuck.member.Mapper;

import com.jt.ssalMuck.member.Entity.Member;
import com.jt.ssalMuck.member.Model.MemberDTO;
import com.jt.ssalMuck.member.Model.MemberDTO.MemberDTOBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T13:23:16+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (AdoptOpenJDK)"
)
@Component
public class LoginMapperImpl implements LoginMapper {

    @Override
    public MemberDTO toDto(Member e) {
        if ( e == null ) {
            return null;
        }

        MemberDTOBuilder memberDTO = MemberDTO.builder();

        memberDTO.userId( e.getUserId() );
        memberDTO.password( e.getPassword() );
        memberDTO.username( e.getUsername() );
        memberDTO.email( e.getEmail() );
        memberDTO.address( e.getAddress() );
        memberDTO.useYn( e.getUseYn() );
        memberDTO.memberRole( e.getMemberRole() );

        return memberDTO.build();
    }

    @Override
    public Member toEntity(MemberDTO d) {
        if ( d == null ) {
            return null;
        }

        Member member = new Member();

        member.setUserId( d.getUserId() );
        member.setPassword( d.getPassword() );
        member.setUsername( d.getUsername() );
        member.setEmail( d.getEmail() );
        member.setAddress( d.getAddress() );
        member.setUseYn( d.getUseYn() );
        member.setMemberRole( d.getMemberRole() );

        return member;
    }

    @Override
    public List<MemberDTO> toDtoList(List<Member> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MemberDTO> list = new ArrayList<MemberDTO>( entityList.size() );
        for ( Member member : entityList ) {
            list.add( toDto( member ) );
        }

        return list;
    }

    @Override
    public List<Member> toEntityList(List<MemberDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Member> list = new ArrayList<Member>( dtoList.size() );
        for ( MemberDTO memberDTO : dtoList ) {
            list.add( toEntity( memberDTO ) );
        }

        return list;
    }

    @Override
    public void updateFromDto(MemberDTO dto, Member entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getUserId() != null ) {
            entity.setUserId( dto.getUserId() );
        }
        if ( dto.getPassword() != null ) {
            entity.setPassword( dto.getPassword() );
        }
        if ( dto.getUsername() != null ) {
            entity.setUsername( dto.getUsername() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getAddress() != null ) {
            entity.setAddress( dto.getAddress() );
        }
        if ( dto.getUseYn() != null ) {
            entity.setUseYn( dto.getUseYn() );
        }
        if ( dto.getMemberRole() != null ) {
            entity.setMemberRole( dto.getMemberRole() );
        }
    }
}
