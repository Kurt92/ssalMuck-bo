package com.ssalMuck.Mapper;

import com.ssalMuck.Dto.Board2DTO;
import com.ssalMuck.Dto.Board2DTO.Board2DTOBuilder;
import com.ssalMuck.Entity.Board2;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-20T18:02:31+0900",
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

        board2DTO.title( e.getTitle() );
        board2DTO.username( e.getUsername() );

        return board2DTO.build();
    }

    @Override
    public Board2 toEntity(Board2DTO d) {
        if ( d == null ) {
            return null;
        }

        Board2 board2 = new Board2();

        board2.setTitle( d.getTitle() );
        board2.setUsername( d.getUsername() );

        return board2;
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

        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
        if ( dto.getUsername() != null ) {
            entity.setUsername( dto.getUsername() );
        }
    }
}
