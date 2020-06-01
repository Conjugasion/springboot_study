package com.example.springaopdemo.Configuration;

import com.example.springaopdemo.Entity.Student;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author tangdongfan
 * @date 2020/5/13 18:14
 */
@Configuration
//@ComponentScan(value="com.example.springaopdemo.Configuration", excludeFilters= {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes= {ExecutorConfig.class})})
public class Config {

    @Bean
    public Student student() {
        Student student = new Student();
        student.setName("Lucas");
        student.setAge(26);
        return student;
    }

}
