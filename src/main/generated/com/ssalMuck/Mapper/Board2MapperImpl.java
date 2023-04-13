package com.ssalMuck.Mapper;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.Dto.Board2DTO.Board2DTOBuilder;
import com.ssalMuck.Entity.Board2;
import com.ssalMuck.Entity.Board2.Board2Builder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-12T16:07:37+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (AdoptOpenJDK)"
)
@Component
public class Board2MapperImpl implements Board2Mapper {

    @Override
    public Board2DTO toDto(Board2 e) {
        if ( e == null ) {
            return null;
        }

        Board2DTOBuilder board2DTO = Board2DTO.builder();

        if ( e.getId() != null ) {
            board2DTO.id( String.valueOf( e.getId() ) );
        }
        board2DTO.title( e.getTitle() );
        board2DTO.content( e.getContent() );
        board2DTO.username( e.getUsername() );
        board2DTO.hit( e.getHit() );
        board2DTO.likeHit( e.getLikeHit() );
        board2DTO.dislike( e.getDislike() );
        board2DTO.delete_yn( e.getDelete_yn() );

        return board2DTO.build();
    }

    @Override
    public Board2 toEntity(Board2DTO d) {
        if ( d == null ) {
            return null;
        }

        Board2Builder board2 = Board2.builder();

        if ( d.getId() != null ) {
            board2.id( Long.parseLong( d.getId() ) );
        }
        board2.title( d.getTitle() );
        board2.content( d.getContent() );
        board2.username( d.getUsername() );
        board2.hit( d.getHit() );
        board2.likeHit( d.getLikeHit() );
        board2.dislike( d.getDislike() );
        board2.delete_yn( d.getDelete_yn() );

        return board2.build();
    }

    @Override
    public List<Board2DTO> toDtoList(List<Board2> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Board2DTO> list = new ArrayList<Board2DTO>( entityList.size() );
        for ( Board2 board2 : entityList ) {
            list.add( toDto( board2 ) );
        }

        return list;
    }

    @Override
    public List<Board2> toEntityList(List<Board2DTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Board2> list = new ArrayList<Board2>( dtoList.size() );
        for ( Board2DTO board2DTO : dtoList ) {
            list.add( toEntity( board2DTO ) );
        }

        return list;
    }

    @Override
    public void updateFromDto(Board2DTO dto, Board2 entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( Long.parseLong( dto.getId() ) );
        }
        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
        if ( dto.getContent() != null ) {
            entity.setContent( dto.getContent() );
        }
        if ( dto.getUsername() != null ) {
            entity.setUsername( dto.getUsername() );
        }
        if ( dto.getHit() != null ) {
            entity.setHit( dto.getHit() );
        }
        if ( dto.getLikeHit() != null ) {
            entity.setLikeHit( dto.getLikeHit() );
        }
        if ( dto.getDislike() != null ) {
            entity.setDislike( dto.getDislike() );
        }
        if ( dto.getDelete_yn() != null ) {
            entity.setDelete_yn( dto.getDelete_yn() );
        }
    }
}
