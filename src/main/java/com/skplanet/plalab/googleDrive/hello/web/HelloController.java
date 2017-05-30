package com.skplanet.plalab.googleDrive.hello.web;

import com.skplanet.plalab.googleDrive.hello.model.Member;
import com.skplanet.plalab.googleDrive.hello.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kyeongmin kim
 */

@RestController
public class HelloController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/list")
    public List<Member> String() {
        List<Member> member = memberRepository.findAll();

        return member;
    }

    @PostMapping("/add")
    public String add(@RequestBody Member member) {

        Member affectedRows = memberRepository.save(member);
        if (affectedRows == null) {
            return "Error!!";
        } else {
            return "Insert member: " + member.getName() + ", " + member.getAge() + "," + member.getSex();
        }
    }

}


