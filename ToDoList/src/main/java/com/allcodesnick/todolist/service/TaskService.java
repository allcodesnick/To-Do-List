package com.allcodesnick.todolist.service;

import com.allcodesnick.todolist.model.Task;

import java.util.List;

public interface TaskService {

    Task saveTask(Task task);

    List<Task> listTask();

    Task getTaskById(Long id);

    void deleteTask(Long id);

    Task updateTask(Task task, Long id);

}
