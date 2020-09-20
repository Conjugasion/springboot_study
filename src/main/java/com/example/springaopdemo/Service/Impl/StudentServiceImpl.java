package com.example.springaopdemo.Service.Impl;

import com.example.springaopdemo.Entity.Student;
import com.example.springaopdemo.Mapper.StudentMapper;
import com.example.springaopdemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tangdongfan
 * @date 2020/5/27 18:17
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Transactional
    @Override
    public boolean saveStudent(Student student) {
        return studentMapper.saveStudent(student);
    }
}
