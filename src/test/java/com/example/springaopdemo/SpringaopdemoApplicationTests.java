package com.example.springaopdemo;

import com.example.springaopdemo.Configuration.ExecutorConfig;
import com.example.springaopdemo.Entity.Student;
import com.example.springaopdemo.Mapper.StudentMapper;
import com.example.springaopdemo.Service.AsyncTask;
import com.example.springaopdemo.Service.BrowserService;
import com.example.springaopdemo.Service.StudentService;
import com.example.springaopdemo.Service.StudentServiceImpl;
import com.example.springaopdemo.Task.ScheduleJob;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

@SpringBootTest
class SpringaopdemoApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SpringaopdemoApplicationTests.class);

	@Autowired
	BrowserService browserService;

	@Autowired
	Student student;

	@Autowired
	@Qualifier("myTaskExecutor")
	TaskExecutor taskExecutor;

	@Autowired
	AsyncTask asyncTask;

	@Autowired
	StudentService studentService;

	@Value("${demo.tdf.name}")
	String name;

	@Value("${demo.tdf.age}")
	Integer age;

	@Autowired
	ScheduleJob scheduleJob;


	@Test
	void test1() {
		browserService.browser("Romance of the Three Kingdoms");
	}

	@Test
	void test2() {
		// calling getBook method first time.
		System.out.println(student.call("Lucas"));
		// calling getBook method second time. This time, method will not
		// execute.
		System.out.println(student.call("Lucas"));
		// calling getBook method third time with different value.
		System.out.println(student.call("Mark"));
	}

	@Test
	void test3() throws InterruptedException {
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
		System.out.println("test end");
	}

	@Test
	void test4() throws InterruptedException {
		long start = System.currentTimeMillis();
		Future<String> taskOne = asyncTask.taskOne();
		Future<String> taskTwo = asyncTask.taskTwo();
		Future<String> taskThree = asyncTask.taskThree();

		while (true) {
			if (taskOne.isDone()&&taskTwo.isDone()&&taskThree.isDone()) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}

	@Test
	void test5() {
		logger.info("age = {}", age);
		System.out.println(age);
	}

	@Test
	void test6() {
		Student s = new Student();
		s.setName(name);
		s.setAge(age);
		studentService.saveStudent(s);
	}


}
