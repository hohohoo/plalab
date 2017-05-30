package com.skplanet.plalab.googleDrive.hello.web;

import com.skplanet.plalab.googleDrive.hello.model.Member;
import com.skplanet.plalab.googleDrive.hello.model.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kyeongmin kim
 */

@RestController
public class HelloController {

    @Autowired
    private MemberDAO memberDAO;

    @RequestMapping("/")
    public List getAllListForBeanPropertyRowMapper() {
        return memberDAO.listForBeanPropertyRowMapper();
    }

    @RequestMapping("/add")
    public String add(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("sex") String sex) {
        Member member = new Member();
        member.setName(name);
        member.setAge(age);
        member.setSex(sex);

        int affectedRows = memberDAO.insert(member);
        if (affectedRows != 1) {
            return "Error!!";
        } else {
            return "Insert member: " + name + ", " + age + "," + sex;
        }
    }

}


