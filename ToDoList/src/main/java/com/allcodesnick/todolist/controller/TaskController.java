package com.allcodesnick.todolist.controller;

import com.allcodesnick.todolist.model.Task;
import com.allcodesnick.todolist.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "create-task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task){
        // save task to database
        taskService.saveTask(task);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){
        // get task from the service
        Task task = taskService.getTaskById(id);
        // set task as a model to pre-populate the form
        model.addAttribute("task", task);
        return "update-task";
    }
}



