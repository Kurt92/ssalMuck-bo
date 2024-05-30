package com.jt.ssalMuck.ctgy.board.dto;

import com.jt.ssalMuck.ctgy.member.dto.MemberDTO;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board2DTO {

    public static class save {

        @Data
        @Builder
        public static class Request {
            private Long id;
            private String flag;

            private String title;
            private String content;
            private String username;
        }
        public static class Response {
            @ApiParam(value="아이디", hidden = true)
            private Long id;

            @ApiParam(value="제목")
            @NotBlank(message = "제목도 없이 글은 쓴다고?")
            private String title;

            @ApiParam(value="내용")
            @NotBlank(message = "내용없는디?")
            private String content;

            @ApiParam(value="유저이름")
            @NotBlank(message = "누구신지요..?")
            private String username;

            @ApiParam(value="조회수")
            private String hit;

            @ApiParam(value="좋아요")
            private String likeHit;

            @ApiParam(value="싫어요")
            private String dislike;

            @ApiParam(value="삭제여부")
            private String delete_yn;
        }

    }



    private MemberDTO memberDTO;
}
