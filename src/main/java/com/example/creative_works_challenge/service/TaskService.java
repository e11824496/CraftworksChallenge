package com.example.creative_works_challenge.service;

import com.example.creative_works_challenge.dto.TaskDto;
import com.example.creative_works_challenge.model.Task;
import com.example.creative_works_challenge.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    private final ModelMapper modelMapper = new ModelMapper();
    private final ModelMapper updateMapper = new ModelMapper();


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

        updateMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

    }


    @Scheduled(cron = "*/15 * * * * *")  //once every 15 sec
    public void addRandomTask() {
        Task t = new Task();
        t.setTitle("title");
        t.setDescription("description");

        taskRepository.save(t);
    }

    public List<TaskDto> findAll() {
        return taskRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(x -> modelMapper.map(x, TaskDto.class))
                .collect(Collectors.toList());
    }

    public TaskDto findByID(Long id) {
        Task task = taskRepository.findById(id);
        if (task == null) {
            throw new IllegalArgumentException();
        }
        return modelMapper.map(task, TaskDto.class);
    }

    public TaskDto deleteById(Long id) {
        List<Task> tasks = taskRepository.deleteById(id);
        if (tasks.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return modelMapper.map(tasks.get(0), TaskDto.class);
    }

    public TaskDto create(TaskDto taskDto) {
        Task task = modelMapper.map(taskDto, Task.class);
        task = taskRepository.save(task);
        return modelMapper.map(task, TaskDto.class);
    }

    public TaskDto updateByID(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id);

        if (task == null) {
            throw new IllegalArgumentException();
        }

        taskDto.setId(null);

        updateMapper.map(taskDto, task);
        task = taskRepository.save(task);
        return modelMapper.map(task, TaskDto.class);
    }
}
