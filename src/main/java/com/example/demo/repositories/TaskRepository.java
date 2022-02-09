package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.TaskModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel, Long>{
    public abstract ArrayList<TaskModel> findByState(Boolean state);
}
