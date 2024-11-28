package com.group2.To_Do_App.service.serviceImpl;

import com.group2.To_Do_App.dto.PriorityUpdateDto;
import com.group2.To_Do_App.dto.TaskRequestDto;
import com.group2.To_Do_App.dto.TaskResponseDto;
import com.group2.To_Do_App.enums.PriorityLevel;
import com.group2.To_Do_App.enums.TaskStatus;
import com.group2.To_Do_App.exception.customException.ResourceNotFoundException;
import com.group2.To_Do_App.model.Task;
import com.group2.To_Do_App.repository.TaskRepository;
import com.group2.To_Do_App.service.TaskService;
import jakarta.annotation.Priority;
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
    public TaskResponseDto editTask(Long id, TaskRequestDto taskRequestDto) {

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task", id));

        existingTask.setTitle(taskRequestDto.getTitle());
        existingTask.setDescription(taskRequestDto.getDescription());

        taskRepository.save(existingTask);

        TaskResponseDto taskResponseDto = TaskResponseDto.builder()
                .id(id)
                .title(taskRequestDto.getTitle())
                .description(taskRequestDto.getDescription())
                .priority(existingTask.getPriority())
                .status(existingTask.getStatus())
                .build();

        return taskResponseDto;
    }

    @Override
    public TaskResponseDto updateTaskStatus(Long taskId, TaskStatus status) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", taskId));
        task.setStatus(status);
        taskRepository.save(task);
        return toResponseDto(task);
    }

    @Override
    public TaskResponseDto updatePriorityLevel(Long taskId, PriorityLevel priority) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", taskId));
        task.setPriority(validatePriority(priority));
        taskRepository.save(task);
        return toResponseDto(task);
    }

    private TaskResponseDto toResponseDto(Task task) {
        return TaskResponseDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .priority(task.getPriority())
                .status(task.getStatus())
                .build();
    }

    @Override
    public void deleteTask(Long taskId) {

    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return null;
    }

    static PriorityLevel validatePriority(PriorityUpdateDto priority){
        return PriorityLevel.getPriority(priority.getPriority());
    }

}
