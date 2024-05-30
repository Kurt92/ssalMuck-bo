package com.jt.ssalMuck.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.ssalMuck.ctgy.board.controller.Board2Controller;
import com.jt.ssalMuck.ctgy.board.dto.Board2DTO;
import com.jt.ssalMuck.ctgy.board.service.Board2Service;
import com.jt.ssalMuck.domain.board.Board2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = Board2Controller.class)
@MockBean(JpaMetamodelMappingContext.class)
public class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    Board2Service board2Service;

    @Test
    @DisplayName("보드 전체조회 api 호출 테스트")
    void getBoard2ListTest() throws Exception {
        // given
        List<Board2> board2List = new ArrayList<>();
        board2List.add(Board2.builder().id(1L).content("123").build());

        given(board2Service.find()).willReturn(board2List);

        // when & then
        mockMvc.perform(get("/board2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("123")))
        ;
    }

    @Test
    @DisplayName("보드 저장 api 호출 테스트")
    void creatBoard2ListTest() throws Exception {
        //BDD

        // given
        // 모킹한 객체의 값과 리턴을 정의한다.
        Board2DTO.save.Request board2 = Board2DTO.save.Request.builder().id(2L).content("New Board").build();
        String requestContent = objectMapper.writeValueAsString(board2);

        willDoNothing().given(board2Service).insert(board2);

        //when
        ResultActions actions =
                mockMvc.perform(
                    post("/board2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestContent)
                )
                .andDo(print());

        //then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$").value("success"));


    }
}
