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
    public void findEmployeeById() {
        task.test();
        System.out.println("test");
    }
}
