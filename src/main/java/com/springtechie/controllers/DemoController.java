package com.springtechie.controllers;

import com.springtechie.service.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @Autowired
    private Task task;
    @GetMapping("/get/id/")
    public String findEmployeeById() throws InterruptedException {
        task.test();
        System.out.println("test");
        return "job is running in the background";
    }
}
