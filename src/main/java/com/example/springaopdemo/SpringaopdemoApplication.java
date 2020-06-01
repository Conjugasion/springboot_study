package com.example.springaopdemo;

import com.example.springaopdemo.Configuration.CacheConfig;
import com.example.springaopdemo.Configuration.Config;
import com.example.springaopdemo.Configuration.ExecutorConfig;
import com.example.springaopdemo.Entity.Student;
import com.example.springaopdemo.Task.ScheduleJob;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableAsync
@MapperScan("com.example.springaopdemo.Mapper")
public class SpringaopdemoApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringaopdemoApplication.class, args);
		// 获取指定bean
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class, CacheConfig.class);
		//ctx.register(Config.class);
		//ctx.refresh();
		/*Student student = ctx.getBean(Student.class);
		System.out.println(student.toString());*/

		/*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class, CacheConfig.class, ExecutorConfig.class);
		TaskExecutor taskExecutor = ctx.getBean(TaskExecutor.class);
		int num = 5;
		CountDownLatch cdl = new CountDownLatch(num);
		for (int i = 0; i < num; i++) {
			taskExecutor.execute(() -> {
				System.out.println(Thread.currentThread().getName() + " start");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " end");
				cdl.countDown();
			});
		}
		cdl.await();
		System.out.println("psvm end");*/

	}

}
