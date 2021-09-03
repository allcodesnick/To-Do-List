package com.allcodesnick.todolist.controller;

import com.allcodesnick.todolist.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Display list of Task
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("TaskList", taskService.listTask());
        return "index";
    }

}



