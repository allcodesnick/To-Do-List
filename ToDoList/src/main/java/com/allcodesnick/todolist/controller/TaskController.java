package com.allcodesnick.todolist.controller;

import com.allcodesnick.todolist.model.Task;
import com.allcodesnick.todolist.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        super();
        this.taskService = taskService;
    }

    // handler method to handle list task and return mode and view
    @GetMapping("/index")
     public String listStudents(Model model){
        model.addAttribute("tasks", taskService.listTask());
        return "tasks";
     }

     @GetMapping("/index/new")
     public String createTaskForm(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "create-task";
     }

}



