package com.example.springaopdemo.Service;

import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author Lucas
 * @date 2020/9/20 16:36
 * 异步调用
 */
public interface AsyncTaskService {

    public Future<String> taskOne() throws InterruptedException;
    public Future<String> taskTwo() throws InterruptedException;
    public Future<String> taskThree() throws InterruptedException;

}
