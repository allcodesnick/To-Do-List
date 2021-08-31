package com.allcodesnick.todolist.controller;

import com.allcodesnick.todolist.model.Task;
import com.allcodesnick.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("toDoList")
public class TaskController {

    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTask")
    public Task saveTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @GetMapping("/list_all")
    public List<Task> taskList(){
        return taskService.listTask();
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/updateTask/{id}")
    public Task updateTask(@RequestBody Task task,@PathVariable Long id){
        return taskService.updateTask(task, id);
    }
}
