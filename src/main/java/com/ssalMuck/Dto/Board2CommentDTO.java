package com.ssalMuck.Dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board2CommentDTO {

    @ApiParam(value="댓글키", hidden = true)
    private String id;

    @ApiParam(value="아이디", hidden = true)
    private String username;

    @ApiParam(value="내용", hidden = true)
    private String comment;

    @ApiParam(value="좋아요", hidden = true)
    private String likeHit;

    @ApiParam(value="삭제여부", hidden = true)
    private String delete_yn;

}
