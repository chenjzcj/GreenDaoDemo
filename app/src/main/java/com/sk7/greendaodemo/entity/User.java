package com.sk7.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户实体类
 * Created by Administrator on 2018/3/15.
 */
@Entity
public class User {
    @Id
    private Long id;
    @Property(nameInDb = "USERNAME")
    private String username;
    @Property(nameInDb = "NICKNAME")
    private String nickName;
    @Property
    private int age;
    @Property
    private String password;

    @Generated(hash = 207559695)
    public User(Long id, String username, String nickName, int age,
            String password) {
        this.id = id;
        this.username = username;
        this.nickName = nickName;
        this.age = age;
        this.password = password;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
