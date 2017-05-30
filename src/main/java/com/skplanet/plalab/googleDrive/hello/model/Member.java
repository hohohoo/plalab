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

}
