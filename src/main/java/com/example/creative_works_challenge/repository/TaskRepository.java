package com.example.creative_works_challenge.repository;

import com.example.creative_works_challenge.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findAllByOrderByCreatedAtDesc();

    Task findById(Long id);

    @Transactional
    List<Task> deleteById(Long id);
}
