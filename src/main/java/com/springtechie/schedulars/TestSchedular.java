package com.springtechie.schedulars;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestSchedular {

    @Scheduled(fixedDelay = 3000)
    public void test() {
        System.out.println("Hello Test" + System.currentTimeMillis());
    }

}
