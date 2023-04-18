package com.ssalMuck.Security.repository;

import com.ssalMuck.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserInfoRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);

}
