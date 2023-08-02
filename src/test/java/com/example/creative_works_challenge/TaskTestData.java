package com.example.creative_works_challenge;

import com.example.creative_works_challenge.dto.TaskDto;
import com.example.creative_works_challenge.model.Task;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Profile("test")
@Component
public class TaskTestData {

    public static Task getDefaultTask(){
        Task task = new Task();
        task.setId(1L);
        task.setDueDate(LocalDateTime.parse("2023-08-02T00:08:30.404853469"));
        task.setPriority(1);
        task.setDescription("Description");
        task.setTitle("Title");
        task.setCreatedAt(LocalDateTime.parse("2023-08-02T00:08:30.404853469"));
        task.setResolvedAt(LocalDateTime.parse("2023-08-02T00:08:30.404853469"));
        task.setStatus("Status");

        return task;
    }

    public static TaskDto getDefaultTaskDto(){
        TaskDto task = new TaskDto();
        task.setId(1L);
        task.setDueDate(LocalDateTime.parse("2023-08-02T00:08:30.404853469"));
        task.setPriority(1);
        task.setDescription("Description");
        task.setTitle("Title");
        task.setCreatedAt(LocalDateTime.parse("2023-08-02T00:08:30.404853469"));
        task.setResolvedAt(LocalDateTime.parse("2023-08-02T00:08:30.404853469"));
        task.setStatus("Status");

        return task;
    }
}
