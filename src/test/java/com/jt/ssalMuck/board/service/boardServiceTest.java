package com.jt.ssalMuck.board.service;

import com.jt.ssalMuck.ctgy.board.service.Board2Service;
import com.jt.ssalMuck.domain.board.Board2;
import com.jt.ssalMuck.domain.board.Board2Repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class boardServiceTest {
    @InjectMocks
    Board2Service board2Service;
    @Mock
    Board2Repository board2Repository;



    @Test
    @DisplayName("리스트 조회")
    void getBoard2ListTest() throws Exception {

        //given
        List<Board2> board2List = new ArrayList<>();
        board2List.add(Board2.builder().id(1L).title("test1").build());
        board2List.add(Board2.builder().id(2L).title("test2").build());
        board2List.add(Board2.builder().id(3L).title("test3").build());
        board2List.add(Board2.builder().id(4L).title("test4").build());
        board2List.add(Board2.builder().id(5L).title("test5").build());
        board2List.add(Board2.builder().id(6L).title("test6").build());
        board2List.add(Board2.builder().id(7L).title("test7").build());
        board2List.add(Board2.builder().id(8L).title("test8").build());
        board2List.add(Board2.builder().id(9L).title("test9").build());
        board2List.add(Board2.builder().id(10L).title("test10").build());

        given(board2Repository.findAll()).willReturn(board2List);


        //when
        List<Board2> result = board2Service.find();


        //then
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(10);
        assertThat(result.get(3).getTitle()).isEqualTo("test4");
    }

    @Test
    @DisplayName("리스트 조회 null테스트")
    void getBoard2ListNullTest() throws Exception {


        //given
        List<Board2> board2List = new ArrayList<>();
        given(board2Repository.findAll()).willReturn(Collections.emptyList());


        //when
        List<Board2> result = board2Service.find();


        //then
//        assertThat(board2List.size()).isNotNull();
        assertThat(result).isEqualTo(board2List);
    }


    @Test
    @DisplayName("상세 조회")
    void getBoard2DetailTest() throws Exception {

        //given
        Long id = 2L;

        //when

        //then


    }

}
