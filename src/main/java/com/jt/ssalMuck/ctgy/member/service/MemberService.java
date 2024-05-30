package com.jt.ssalMuck.ctgy.member.service;

import com.jt.ssalMuck.domain.member.Member;
import com.jt.ssalMuck.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor  //final이 붙어있는 필드만 생성자 생성
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     * */
    @Transactional
    public String join(Member member) {
        //벨리데이션
        validateDuplicateMember(member);  //중복 회원 검증
        memberRepository.save(member);
        return member.getUserId();
    }

    /**
     * 회원가입 벨리데이션
     * */
    private void validateDuplicateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByUsername(member.getUsername());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 있어용!");
        }
    }

    /**
     * 회원전체조회
     * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    /**
     * 회원전체조회
     * */
//    public Member member(String memberId) {
//        return memberRepository.findOne(memberId);
//    }

}
