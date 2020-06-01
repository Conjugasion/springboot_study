package com.example.springaopdemo.Task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author tangdongfan
 * @date 2020/6/1 14:03
 * 定时任务
 * 异步执行，多线程
 */
@Component
@EnableScheduling
@Async
public class ScheduleJob {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void runfirst(){
        System.out.println("********first job is 整分钟只执行一次，线程：" + Thread.currentThread().getName());

    }

    @Scheduled(fixedRate = 1000 * 10)
    public void runsecend(){
        System.out.println("********second job is 10秒钟执行一次，线程：" + Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay=2000)
    public void runThird(){
        System.out.println("********third job is 2秒执行一次，线程：" + Thread.currentThread().getName());
    }

}
