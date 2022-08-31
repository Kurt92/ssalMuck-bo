package com.ssalMuck.service;

import com.ssalMuck.Entity.Member;
/*import com.ssalMuck.Repository.MemberRepository;*/
import com.ssalMuck.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     * */
    @Transactional
    public String join(Member member) {
        //벨리데이션
        validateDuplicateMember(member);  //중복 회원 검증
        /*memberRepository.save(member);*/
        return member.getId();
    }

    /**
     * 회원가입 벨리데이션
     * */
    private void validateDuplicateMember(Member member) {
        //EXCEPTION
        /*List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 있어용!");
        }*/
    }

    /**
     * 회원전체조회
     * */
    /*public List<Member> findMembers() {
        return memberRepository.findAll();
    }*/
    /**
     * 회 원전체조회
     * */
   /* public Member member(String memberId) {
        return memberRepository.findOne(memberId);
    }*/

}
