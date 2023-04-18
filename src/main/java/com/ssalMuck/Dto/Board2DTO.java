package com.ssalMuck.Dto;

import io.swagger.annotations.ApiParam;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board2DTO {
    @ApiParam(value="아이디", hidden = true)
    private String id;
    @ApiParam(value="제목")
    private String title;
    @ApiParam(value="내용")
    private String content;
    @ApiParam(value="유저이름")
    private String username;
    @ApiParam(value="조회수")
    private String hit;
    @ApiParam(value="좋아요")
    private String likeHit;
    @ApiParam(value="싫어요")
    private String dislike;
    @ApiParam(value="삭제여부")
    private String delete_yn;

    private MemberDTO memberDTO;
}
