package com.edu.neu.homework1.entity;

import java.io.Serializable;

/**
 * 用户的实体类，有用户名，密码，邮箱，电话，地址，生日
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String realname;
    private String age;
    private String gender;
    private String email;
    private String phone;
    private String address;


    public User(String username, String password, String realname, String age, String gender, String email, String phone, String address) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Serializable
     */
    private static final long serialVersionUID = 1L;
}
