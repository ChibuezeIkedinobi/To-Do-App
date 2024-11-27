package com.group2.To_Do_App.service;

import com.group2.To_Do_App.dto.TaskRequestDto;
import com.group2.To_Do_App.dto.TaskResponseDto;
import com.group2.To_Do_App.enums.PriorityLevel;
import com.group2.To_Do_App.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    TaskResponseDto createTask(TaskRequestDto taskRequestDto);
    TaskResponseDto editTask(Long taskId, TaskRequestDto taskRequestDto, Long userId);
    TaskResponseDto updateTaskStatus(Long taskId, TaskStatus status);
    TaskResponseDto updatePriorityLevel(Long taskId, PriorityLevel priority);
    void deleteTask(Long taskId);
    List<TaskResponseDto> getAllTasks();

}
