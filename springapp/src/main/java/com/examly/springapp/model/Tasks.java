package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Mark the class as Entity
@Entity
// Defining the class name as Table name
@Table
public class Tasks { 
    // Defining the id as a primary key
    @Id
    @Column
    private int taskId;
    @Column
    private String taskHolderName;
    @Column
    private String taskDate;
    @Column
    private String taskName;
    @Column
    private String taskStatus;
    public int getTaskId(){
        return taskId;
    }
    public void setTaskId(int taskId){
        this.taskId = taskId;
    }
    public String getTaskHolderName(){
        return taskHolderName;
    }
    public void setTaskHolderName(String taskHolderName){
        this.taskHolderName = taskHolderName;
    }
    public String getTaskDate(){
        return taskDate;
    }
    public void settTaskDate(String taskDate){
        this.taskDate = taskDate;
    }
    public String getTaskName(){
        return taskName;
    }
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
    public String getTaskStatus(){
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus){
        this.taskStatus = taskStatus;
    }
}