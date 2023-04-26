package com.jt.ssalMuck.member.Ropository;

import com.jt.ssalMuck.member.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginRepository extends JpaRepository<Member, String> {

}
