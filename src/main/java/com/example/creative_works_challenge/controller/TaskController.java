package com.example.creative_works_challenge.controller;

import com.example.creative_works_challenge.dto.TaskDto;
import com.example.creative_works_challenge.model.Task;
import com.example.creative_works_challenge.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping()
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        try {
            List<TaskDto> tasks = taskService.findAll();

            if (tasks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDto> getById(@PathVariable Long id) {
        try {
            TaskDto task = taskService.findByID(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
