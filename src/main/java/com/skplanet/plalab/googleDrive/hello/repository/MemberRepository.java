package com.skplanet.plalab.googleDrive.hello.repository;

import com.skplanet.plalab.googleDrive.hello.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kyeongmin kim
 */
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
