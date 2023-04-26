package com.jt.ssalMuck.member.Model;

import com.jt.framework.Security.MemberRole;
import com.jt.ssalMuck.member.Entity.Address;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Builder
@Data
@AllArgsConstructor //해당 클레스 필드에 모든 생성자 생성
//기본 생성자 생성
//접근권한 protected 로 설정하여 아무데서나 객체를 생성하는것을 막는다
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//빌더의 메소드면 지정
/*@Builder(builderMethodName = "MemberBuilder")*/

public class MemberDTO {

    @ApiParam(value="아이디", required=true, example="chcch123")
    @NotBlank(message = "아이디가 짧을지도?")
    private String user_id;

    @ApiParam(value="비밀번호")
    @NotBlank
    @Size(min = 6, max = 20, message = "비번이가 짧을지도?")
    private String password;

    private String username;

    private String email;

    private Address address;

    private String useYn;

    private MemberRole memberRole;

    public MemberDTO() {

    }








    /*@Builder(builderMethodName = "MemberBuilder")
    public MemberDTO (String id){
        this.id=id;
    }*/
    //Builder 방식
    //갹체지향 : 하나의 클래스에는 하니의 역할(책임)만 들어가야 한다.
    //           => 변환역할은 독립적인 클래스로 작성하는게 바람직함
    /*public Member toEntity(){
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
    }*/

}
