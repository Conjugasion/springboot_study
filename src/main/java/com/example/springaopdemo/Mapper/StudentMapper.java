package com.example.springaopdemo.Mapper;

import com.example.springaopdemo.Entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author tangdongfan
 * @date 2020/5/27 17:54
 */
//@Mapper
@Repository
public interface StudentMapper {
    @Insert("insert into student(name, age) values(#{name}, #{age})")
    boolean saveStudent(Student student);
}
