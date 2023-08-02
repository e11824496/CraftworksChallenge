package com.example.creative_works_challenge.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime resolvedAt;
    private Integer priority;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
