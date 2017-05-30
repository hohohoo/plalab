package com.skplanet.plalab.googleDrive.hello.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kyeongmin kim
 */
@Repository
public class MemberDAO {

    @Autowired
    private JdbcTemplate template;

    public List<Member> listForBeanPropertyRowMapper() {
        String query = "SELECT * FROM member";
        return template.query(query, new BeanPropertyRowMapper(Member.class));
    }

    public int insert(Member member) {
        String query = "INSERT INTO member(name, age, sex) VALUES(?, ?, ?)";
        return template.update(query, member.getName(), member.getAge(), member.getSex());
    }

}