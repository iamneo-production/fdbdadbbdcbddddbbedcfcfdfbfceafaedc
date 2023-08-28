package com.examly.springapp.controller;

import java.util.*;

import com.examly.springapp.service.TasksService;
import com.examly.springapp.model.Tasks;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TasksController {

@Autowired
TasksService tasksservice;
@PostMapping("/saveTask")
public ResponseEntity<Integer> saveTask(@RequestBody Tasks tasks) 
{
    tasksservice.saveTasks(tasks);
    return new ResponseEntity<>(tasks.getTaskId(), HttpStatus.OK);
}
@PutMapping("/changeStatus/{taskId}")
public ResponseEntity<Integer> changeTaskStatus(@RequestParam("id") int taskId, @RequestParam("status") String status)
{
    tasksservice.updateTaskStatus(taskId, status);
    return new ResponseEntity<>(taskId, HttpStatus.OK);
}    
@DeleteMapping("/deleteTask/{taskId}")
public void deleteTask(@PathVariable("taskid") int taskid)
{
    tasksservice.delete(taskid);
}
@GetMapping("/alltasks")
public List<Tasks> getAllTasks()
{
    return tasksservice.getAllTasks();
}
@GetMapping("/getTask/{taskId}")
public Tasks getTask(@PathVariable("taskId") int taskId)
{
    return tasksservice.getTaskById(taskId);
}
}