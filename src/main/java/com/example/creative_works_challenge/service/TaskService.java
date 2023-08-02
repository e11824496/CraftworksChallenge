package com.example.creative_works_challenge.service;

import com.example.creative_works_challenge.model.Task;
import com.example.creative_works_challenge.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Scheduled(cron = "*/15 * * * * *")  //once every 15 sec
    public void addRandomTask() {
        Task t = new Task();
        t.setTitle("title");
        t.setDescription("description");

        taskRepository.save(t);
    }

    public List<Task> findAll() {
        return taskRepository.findAllByOrderByCreatedAtDesc();
    }
}
