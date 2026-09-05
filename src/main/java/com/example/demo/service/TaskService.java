package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Task;

@Service 
public class TaskService {

    private List<Task> allTasks = new ArrayList<> (Arrays.asList(
        new Task(1L, "勉強", "WebAPIの勉強をする"),
        new Task(2L, "開発", "実際にWebAPIを作ってみる"),
        new Task(3L, "ドキュメンテーション", "作ったWebAPIのドキュメントを作成する")
    ));
    
    public List<Task> getAllTasks() {
        return allTasks;
    }

    public Task getTaskById(Long id) {
        return allTasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public  void addTask(Task task) {
        allTasks.add(task);
    }

}
