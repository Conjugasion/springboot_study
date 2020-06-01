package com.example.springaopdemo.Entity;

import org.springframework.cache.annotation.Cacheable;

/**
 * @author tangdongfan
 * @date 2020/5/13 18:17
 */
public class Student {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Cacheable(value = {"studentCache"},key = "#name")
    public String call(String name) {
        System.out.println("Method executed..");
        if (name.equals("Lucas")) {
            return "Lucas:26";
        } else {
            return "others";
        }
    }
}
