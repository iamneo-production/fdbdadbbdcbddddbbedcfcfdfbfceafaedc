package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.examly.springapp.TaskNotFoundException;
import com.examly.springapp.repository.TasksRepository;
import com.examly.springapp.model.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Defining the business logic
@Service
public class TasksService {
    @Autowired    
    TasksRepository tasksRepository;
    // 1. Saving a specific record by using the method save() of CrudRepository
    public void saveTasks(Tasks tasks)
    {
        tasksRepository.save(tasks);
    }
    // 2. Updating a specific record's taskStatus
    public void updateTaskStatus(int taskId, String status) {
        Optional<Tasks> task = tasksRepository.findById(taskId);
        if(task.isPresent()) 
        {
            Tasks t = task.get();
            t.setTaskStatus(status);
            tasksRepository.save(t);
        }
    }
    // 3. Deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        tasksRepository.deleteById(id);
    }
    // 4. Getting all books record by using the method findAll() of CrudRepository
    public List<Tasks> getAllTasks()
    {
        List<Tasks> tasks = new ArrayList<>();
        tasksRepository.findAll().forEach(tasks::add);
        return tasks;
    }
    // 5. Getting a specific record by using the method findById() of CrudRepository
    public Tasks getTaskById(int id) {
        Optional<Tasks> task = tasksRepository.findById(id);
        if(task.isPresent()) {
            return task.get();
        }else{
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
    }
}