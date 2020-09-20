package com.example.springaopdemo.Service.Impl;

import com.example.springaopdemo.Service.AsyncTaskService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author tangdongfan
 * @date 2020/5/14 18:16
 */
@Service
public class AsyncTaskServiceImpl implements AsyncTaskService {

    public static Random random =new Random();

    @Async
    @Override
    public Future<String> taskOne() throws InterruptedException {
        System.out.println("开始做任务1");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务1，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务1完成");
    }

    @Async
    @Override
    public Future<String> taskTwo() throws InterruptedException {
        System.out.println("开始做任务2");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务2，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务2完成");
    }

    @Async
    @Override
    public Future<String> taskThree() throws InterruptedException {
        System.out.println("开始做任务3");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务3，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务3完成");
    }
}
