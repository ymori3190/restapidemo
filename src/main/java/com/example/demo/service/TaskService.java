package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    // 全件取得
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // IDで取得
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // 新規作成
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    // 更新
    public void updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            updatedTask.setId(id); // IDを設定して更新
            taskRepository.save(updatedTask);
        }
    }

    // 削除
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
