package com.skplanet.plalab.googleDrive.hello.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author kyeongmin kim
 */
@Data
@Entity
public class Member implements Serializable{

    @Id @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String sex;

    public Member() {

    }

    public Member(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setMember(Member member) {
        this.age = member.getAge();
        this.sex = member.getSex();
        this.name = member.getName();
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public Member setAge(int age) {
        this.age = age;
        return this;
    }

    public Member setSex(String sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":" + name +
                ", \"age\":" + age +
                ", \"sex\":" + sex +
                '}';
    }

    //    public Member build(){
//
//    }
}
