package com.learning.task_manager.Exceptions;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskAlreadyPresentException extends RuntimeException {

public TaskAlreadyPresentException(String message){
   super(message);
}
    
}
