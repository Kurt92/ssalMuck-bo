package com.jt.framework.Security.repository;

import com.jt.ssalMuck.member.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserInfoRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);

}
