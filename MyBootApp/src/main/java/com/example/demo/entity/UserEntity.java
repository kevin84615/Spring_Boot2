package com.example.demo.entity;

import javax.persistence.*;


@Entity
@Table(name = "t_user")
public class UserEntity 
{

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_user")
    public String userid;

    @Column(name = "t_password")
    public String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userid;
    }

    public void setUserId(String userid) {
        this.userid = userid;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

}
