package com.example.creative_works_challenge;

import com.example.creative_works_challenge.dto.TaskDto;
import com.example.creative_works_challenge.model.Task;
import com.example.creative_works_challenge.repository.TaskRepository;
import com.example.creative_works_challenge.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class TaskServiceTest {

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void findAll_noTask_emptyList(){
        given(taskRepository.findAllByOrderByCreatedAtDesc()).willReturn(new ArrayList<Task>());

        List<TaskDto> tasks = taskService.findAll();
        assertThat(tasks).isEmpty();
    }

    @Test
    public void findAll_oneTask_oneTaskDto(){
        List<Task> tasks = new ArrayList<>(List.of(TaskTestData.getDefaultTask()));
        given(taskRepository.findAllByOrderByCreatedAtDesc()).willReturn(tasks);

        List<TaskDto> r_tasks = taskService.findAll();
        assertThat(r_tasks).hasSize(1);
        assertThat(r_tasks.get(0)).isEqualTo(TaskTestData.getDefaultTaskDto());
    }

    @Test
    public void findAll_multipleTasks_multipleTaskDtos(){
        Task task1 = TaskTestData.getDefaultTask();
        TaskDto taskDto1 = TaskTestData.getDefaultTaskDto();

        Task task2 = TaskTestData.getDefaultTask();
        task2.setStatus("new Status");
        TaskDto taskDto2 = TaskTestData.getDefaultTaskDto();
        taskDto2.setStatus("new Status");

        List<Task> tasks = new ArrayList<>(List.of(task1, task2));
        given(taskRepository.findAllByOrderByCreatedAtDesc()).willReturn(tasks);

        List<TaskDto> r_tasks = taskService.findAll();
        assertThat(r_tasks).hasSize(2);
        assertThat(r_tasks.get(0)).isEqualTo(taskDto1);
        assertThat(r_tasks.get(1)).isEqualTo(taskDto2);

    }
}
