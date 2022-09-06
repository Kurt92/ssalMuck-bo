package com.ssalMuck.Dto;

import com.ssalMuck.Entity.Address;
import com.ssalMuck.Entity.Member;
import io.swagger.annotations.ApiParam;
import lombok.*;



@Data
//해당 클레스 필드에 모든 생성자 생성
@AllArgsConstructor
//기본 생성자 생성
//접근권한 protected 로 설정하여 아무데서나 객체를 생성하는것을 막는다
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//빌더의 메소드면 지정
/*@Builder(builderMethodName = "MemberBuilder")*/
@Builder
public class MemberDTO {

    @ApiParam(value="아이디", required=true, example="chcch123")
    private String id;

    @ApiParam(value="비밀번호")
    private String password;

    private String name;

    private Address address;


    /*@Builder(builderMethodName = "MemberBuilder")
    public MemberDTO (String id){
        this.id=id;


    }*/

    public Member toEntity(){
        Member member = new Member();
        member.setId(this.id);
        member.setPassword(this.password);
        return member;
    }
    public MemberDTO toDto(Member member){
        return MemberDTO.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }

}
