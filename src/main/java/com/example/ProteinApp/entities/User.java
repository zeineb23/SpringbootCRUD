package com.example.ProteinApp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long id;
    @Column(name = "lname", length = 255)
    private String lname;

    @Column(name = "fname", length = 255)
    private String fname;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "pwd", length = 255)
    private String pwd;



    public User() {
        super();
    }
    public Long getId() {
        return id;
    }

    public User(Long id, String email, String pwd, String fname, String lname) {
        super();
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.fname = fname;
        this.lname = lname;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

}