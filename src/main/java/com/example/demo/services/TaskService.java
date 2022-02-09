package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.TaskModel;
import com.example.demo.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public ArrayList<TaskModel> getTasks(){
        return (ArrayList<TaskModel>) taskRepository.findAll();
    }

    public TaskModel saveTask(TaskModel task){
        return taskRepository.save(task);
    }

    public ArrayList<TaskModel> getByState(Boolean state){
        return taskRepository.findByState(state);
    }

    public boolean deleteTask(Long id){
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            //TODO: handle exception
            return false;
        }
    }
}
