package com.jt.ssalMuck.member.Ropository;

import com.jt.ssalMuck.member.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILoginRepository extends JpaRepository<Member, String> {
    Optional<Member> findByUserIdAndPassword(String user_id, String password);
}
