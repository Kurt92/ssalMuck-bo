package com.ssalMuck.Mapper;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Dto.MemberDTO.MemberDTOBuilder;
import com.ssalMuck.Entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-17T18:10:30+0900",
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

        memberDTO.user_id( e.getUser_id() );
        memberDTO.password( e.getPassword() );
        memberDTO.name( e.getName() );
        memberDTO.address( e.getAddress() );

        return memberDTO.build();
    }

    @Override
    public Member toEntity(MemberDTO d) {
        if ( d == null ) {
            return null;
        }

        Member member = new Member();

        member.setUser_id( d.getUser_id() );
        member.setPassword( d.getPassword() );
        member.setName( d.getName() );
        member.setAddress( d.getAddress() );

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

        if ( dto.getUser_id() != null ) {
            entity.setUser_id( dto.getUser_id() );
        }
        if ( dto.getPassword() != null ) {
            entity.setPassword( dto.getPassword() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getAddress() != null ) {
            entity.setAddress( dto.getAddress() );
        }
    }
}
