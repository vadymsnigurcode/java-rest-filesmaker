package com.example.filesmaker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.*;

@RestController
public class FilesController {

    @PostMapping
    public void createFiles() {

    }

    @GetMapping
    public String getFiles(@RequestParam int count) {
        long start1 = System.currentTimeMillis();
        int coresCount = Runtime.getRuntime().availableProcessors();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(coresCount);

        for (int i = 1; i <= count; i++)
        {
            TaskExecutor task = new TaskExecutor(Integer.toString(i));
            System.out.println("Created : " + task.getName());

            executor.execute(task);
        }
        executor.shutdown();
        long start2 = System.currentTimeMillis();
        return Long.toString(start2-start1);
    }

}
