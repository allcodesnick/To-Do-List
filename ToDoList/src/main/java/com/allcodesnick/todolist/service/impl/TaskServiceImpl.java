package com.allcodesnick.todolist.service.impl;

import com.allcodesnick.todolist.model.Task;
import com.allcodesnick.todolist.repository.TaskRepository;
import com.allcodesnick.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> listTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTask(long id) {
        Task task = taskRepository.findById(id).orElse(null);
        taskRepository.delete(task);
    }

    @Override
    public Task updateTask(Task task, long id) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        existingTask.setTaskName(task.getTaskName());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setCompleted(task.isCompleted());
        return taskRepository.save(existingTask);
    }
}
