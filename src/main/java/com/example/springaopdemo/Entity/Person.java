package com.example.springaopdemo.Entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author Lucas
 * @date 2020/9/20 15:47
 */
public class Person {

    private String name;
    private int age;
    @JSONField(format = "yyyy-MM-dd HH")
    private Date Birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Birthday=" + Birthday +
                '}';
    }
}
