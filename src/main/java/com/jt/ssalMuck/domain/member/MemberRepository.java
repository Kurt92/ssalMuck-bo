package com.jt.ssalMuck.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByUserIdAndPassword(String user_id, String password);
    List<Member> findByUsername(String username);
}
