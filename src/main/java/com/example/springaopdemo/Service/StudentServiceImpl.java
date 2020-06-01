package com.example.springaopdemo.Service;

import com.example.springaopdemo.Entity.Student;
import com.example.springaopdemo.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tangdongfan
 * @date 2020/5/27 18:17
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public boolean saveStudent(Student student) {
        return studentMapper.saveStudent(student);
    }
}
