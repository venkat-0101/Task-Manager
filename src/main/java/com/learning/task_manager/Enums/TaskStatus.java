package com.learning.task_manager.Enums;

public enum TaskStatus {

    NEW("STATUS_NEW"),
    ACTIVE("STATUS_ACTIVE");

    private String status;

    private TaskStatus(String status){
       this.status = status; 
    }
    
    public String getStatus(){
        return status;
    }
}
