package net.xdclass.demo2.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

public class User {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int age;

    @JsonIgnore
    private String pwd;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("account")
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTIme;


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(int age, String pwd, String phone, Date createTIme) {
        this.age = age;
        this.pwd = pwd;
        //this.phone = phone;
        this.createTIme = createTIme;
    }

    public Date getCreateTIme() {
        return createTIme;
    }

    public void setCreateTIme(Date createTIme) {
        this.createTIme = createTIme;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
