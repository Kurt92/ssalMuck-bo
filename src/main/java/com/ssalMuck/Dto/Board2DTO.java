package com.ssalMuck.Dto;

import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Board2DTO {
    /*@ApiParam(value="아이디", hidden = true)
    private int id;*/

    @ApiParam(value="제목")
    private String title;
    @ApiParam(value="유저이름")
    private String username;
    @ApiParam(value="생성일시")
    private String createDT;



}
