package com.springtechie.service;

import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

@Service
public class Task {

    @Async(value = "threadPoolTaskExecutor")
    public void test() throws InterruptedException{
        System.out.println("test method job started");
        for (int i = 0; i < 1000; i++) {
            // long time taking task.
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("Hello" +i);
        }
    }

}
