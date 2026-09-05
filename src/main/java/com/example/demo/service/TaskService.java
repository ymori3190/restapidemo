package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Task;

@Service 
public class TaskService {

    private List<Task> allTasks = new ArrayList<> (Arrays.asList(
        new Task(1L, "Task 1", "Description for Task 1"),
        new Task(2L, "Task 2", "Description for Task 2"),
        new Task(3L, "Task 3", "Description for Task 3")
    ));
    
    public List<Task> getAllTasks() {
        return allTasks;
    }
}
