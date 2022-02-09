package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.demo.models.TaskModel;
import com.example.demo.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping()
    public ArrayList<TaskModel> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public TaskModel saveTask(@RequestBody TaskModel task){
        return this.taskService.saveTask(task);
    }

    @GetMapping("/query")
    public ArrayList<TaskModel> getTaskByState(@RequestParam("state") Boolean state){
        return this.taskService.getByState(state);
    }

    @DeleteMapping(path = "/{id}")
    public HashMap<String, Object> deleteTaskById(@PathVariable("id") Long id){
        boolean ok = this.taskService.deleteTask(id);

        HashMap<String, Object> resp = new HashMap<>();

        if (ok) {
            resp.put("id", id);
            resp.put("status", true);
            resp.put("msm", "Se elimino correctamente");

            return resp;
        } else {
            resp.put("status", false);
            resp.put("msm", "No se pudo eliminar" );
            return resp;
        }
    }
}
