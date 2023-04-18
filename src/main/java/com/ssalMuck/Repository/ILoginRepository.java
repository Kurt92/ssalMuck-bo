package com.ssalMuck.Repository;

import com.ssalMuck.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginRepository extends JpaRepository<Member, String> {

}
