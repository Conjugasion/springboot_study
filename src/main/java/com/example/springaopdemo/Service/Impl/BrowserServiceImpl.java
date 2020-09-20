package com.example.springaopdemo.Service.Impl;

import com.example.springaopdemo.Entity.Student;
import com.example.springaopdemo.Aspect.MyAopAnnotation;
import com.example.springaopdemo.Service.BrowserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tangdongfan
 * @date 2020/5/13 17:09
 */
@Service
public class BrowserServiceImpl implements BrowserService {

    @Resource
    Student student;

    @Override
    @MyAopAnnotation
    public void browser(String book) {
        System.out.println(student.toString() + " is reading " + book);
    }
}
