package com.learning.task_manager.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.task_manager.Exceptions.TaskAlreadyPresentException;
import com.learning.task_manager.Model.Task;
import com.learning.task_manager.Service.TaskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tasks")
public class TaskController {


    @Autowired
    private TaskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        if(!taskService.isTaskPresent(task.getName())){
           Task savedTask = taskService.saveTask(task);
            return ResponseEntity.ok(savedTask);
        }
        else{
            return ResponseEntity.badRequest().body("task already exists");
        }
    }
    

    @GetMapping("/allTasks")
    public ResponseEntity<?> getAllTasks() {
        List<Task> allTasks = taskService.getAllTasks();
        return  ResponseEntity.ok(allTasks);
    }
    

    @GetMapping("/{name}")
    public ResponseEntity<?> getTask(@PathVariable String name)
    {
     return taskService.findTask(name).<ResponseEntity<?>>map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(name+" is not present"));   
    }


    
}
