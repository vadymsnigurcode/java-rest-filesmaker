package com.example.filesmaker.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class TaskExecutor implements Runnable {
    private String name;

    public TaskExecutor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            Path path = Paths.get("C:\\\\tmp");
            String str = dtf.format(now);
            BufferedWriter writer = new BufferedWriter(new FileWriter(path+"\\file_"+getName()+".txt"));
            writer.write(str);

            writer.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}