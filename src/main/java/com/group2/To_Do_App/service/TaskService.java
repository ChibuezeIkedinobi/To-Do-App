package com.group2.To_Do_App.service;

import com.group2.To_Do_App.dto.TaskCreationDto;
import com.group2.To_Do_App.dto.TaskRequestDto;
import com.group2.To_Do_App.dto.TaskResponseDto;
import com.group2.To_Do_App.dto.payLoadResponse.Response;
import com.group2.To_Do_App.enums.PriorityLevel;
import com.group2.To_Do_App.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    Response createTask(TaskCreationDto taskCreationDto);
    TaskResponseDto editTask(Long taskId, TaskRequestDto taskRequestDto);
    TaskResponseDto updateTaskStatus(Long taskId, TaskStatus status);
    TaskResponseDto updatePriorityLevel(Long taskId, PriorityLevel priority);
    void deleteTask(Long taskId);
    List<TaskResponseDto> getAllTasks();

}
