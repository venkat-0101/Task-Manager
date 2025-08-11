package com.learning.task_manager.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.task_manager.Model.Task;
import com.learning.task_manager.Repository.TaskRepository;


@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    //Find a task using the task name
    public Task findTask(String taskName){
       Optional<Task> optionalTask = taskRepository.findByname(taskName);
        if(optionalTask.isPresent()){
            return optionalTask.get();
        }
        else{
            throw new RuntimeException(taskName+" Not found");
        }  
    }


    //save a new task that is created by the user
    public Task saveTask(Task task)
    {
    //Setting the current time of task creation
     task.setCreatedAt(LocalDateTime.now());
     return taskRepository.save(task);   
    }

    //Checking if the task is present or not
    public boolean isTaskPresent(String taskName){
        Optional<Task> optionalTask = taskRepository.findByname(taskName);
        return optionalTask.isPresent(); 
    }

    //Get all the tasks in DB
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void removeTask(String taskName){
        Optional<Task> optionalTask = taskRepository.findByname(taskName);{
            if (optionalTask.isPresent()) {
                taskRepository.delete(optionalTask.get());
            }
            else
            {
                throw new RuntimeErrorException(null, "Task Not Found");
            }
        }
    }
    
}
