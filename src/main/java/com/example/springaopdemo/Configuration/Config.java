package com.example.springaopdemo.Configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.springaopdemo.Entity.Student;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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
    /*
    * springboot默认配置了消息转换器，utf-8
    *自定义消息转换器--防止出现乱码
    */
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        // StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.ISO_8859_1);
        return converter;
    }

    /*
     * 不采用springboot默认json转换器，使用fastjson
     */
    @Bean
    public HttpMessageConverters fastjsonMessageConverter() {
        // 创建fastjson消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        // 创建fastjson配置对象
        FastJsonConfig config = new FastJsonConfig();
        // 对json数据进行格式化
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        converter.setFastJsonConfig(config);
        HttpMessageConverter<?> con = converter;
        return new HttpMessageConverters(con);
    }
}
