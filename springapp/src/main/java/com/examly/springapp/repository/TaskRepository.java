package com.examly.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.examly.springapp.model.Tasks;

public interface TasksRepository extends CrudRepository<Tasks, Integer>
{ 
    
}