package com.example.creative_works_challenge.service;

import com.example.creative_works_challenge.model.Task;
import com.example.creative_works_challenge.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAllByOrderByCreatedAtDesc();
    }
}
