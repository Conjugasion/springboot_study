package com.example.springaopdemo.Mapper;

import com.example.springaopdemo.Entity.TestTeacher;

public interface TestTeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestTeacher record);

    int insertSelective(TestTeacher record);

    TestTeacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTeacher record);

    int updateByPrimaryKey(TestTeacher record);
}