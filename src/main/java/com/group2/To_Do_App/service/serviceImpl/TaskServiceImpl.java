package com.group2.To_Do_App.service.serviceImpl;

import com.group2.To_Do_App.dto.TaskRequestDto;
import com.group2.To_Do_App.dto.TaskResponseDto;
import com.group2.To_Do_App.enums.PriorityLevel;
import com.group2.To_Do_App.enums.TaskStatus;
import com.group2.To_Do_App.emums.PriorityLevel;
import com.group2.To_Do_App.emums.TaskStatus;
import com.group2.To_Do_App.exception.customException.ResourceNotFoundException;
import com.group2.To_Do_App.model.Task;
import com.group2.To_Do_App.repository.TaskRepository;
import com.group2.To_Do_App.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public TaskResponseDto editTask(Long taskId, TaskRequestDto taskRequestDto, Long userId) {

        // get task that belongs to the user to edit
        Task existingTask = taskRepository.findByTaskIdAndUserId(taskId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found or not authorized"));

        //build entity to save
        existingTask.setTitle(taskRequestDto.getTitle());
        existingTask.setDescription(taskRequestDto.getDescription());
        existingTask.setPriority(taskRequestDto.getPriority());
        existingTask.setStatus(taskRequestDto.getStatus());

        taskRepository.save(existingTask);

        TaskResponseDto taskResponseDto = TaskResponseDto.builder()
                .id(taskId)
                .title(taskRequestDto.getTitle())
                .description(taskRequestDto.getDescription())
                .priority(taskRequestDto.getPriority())
                .status(taskRequestDto.getStatus())
                .build();


        return taskResponseDto;
    }

    @Override
    public TaskResponseDto updateTaskStatus(Long taskId, TaskStatus status) {
        return null;
    }

    @Override
    public TaskResponseDto updatePriorityLevel(Long taskId, PriorityLevel priority) {
        return null;
    }

    @Override
    public void deleteTask(Long taskId) {

    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return null;
    }
}
