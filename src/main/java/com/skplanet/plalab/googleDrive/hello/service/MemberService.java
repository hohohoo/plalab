package com.skplanet.plalab.googleDrive.hello.service;

import com.skplanet.plalab.googleDrive.hello.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kyeongmin kim
 */

public interface MemberService {

    String add(Member member);

    List<Member> getAllMember();

    void delete(Integer id);

    void update(Integer id, Member member);

}
