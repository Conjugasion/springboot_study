package com.example.springaopdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 开启异步调用
@MapperScan("com.example.springaopdemo.Mapper")
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

}

// 打成war包的必要配置 包括启动类、pom文件共计三处修改
/*public class SpringBootApp extends SpringBootServletInitializer {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringBootApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootApp.class);
	}
}*/
