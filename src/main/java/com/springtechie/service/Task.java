package com.springtechie.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task {
    @Async(value = "threadPoolTaskExecutor")
    public void test() {
        for (int i = 0; i < 100; i++) {
            if(i==50) {
                throw new RuntimeException("Hello");
            }
            System.out.println("Hello" +i);
        }
    }

}
