package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user")
public class UserEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_user")
    private String user_id;

    @Column(name = "t_password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getuser() {
        return user_id;
    }

    public void setuser(String user_id) {
        this.user_id = user_id;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

}
