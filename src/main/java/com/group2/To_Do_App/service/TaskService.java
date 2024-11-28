package com.group2.To_Do_App.service;

import com.group2.To_Do_App.dto.PriorityUpdateDto;
import com.group2.To_Do_App.dto.StatusUpdateDto;
import com.group2.To_Do_App.dto.TaskRequestDto;
import com.group2.To_Do_App.dto.TaskResponseDto;
import com.group2.To_Do_App.dto.payLoadResponse.Response;
import com.group2.To_Do_App.enums.PriorityLevel;
import com.group2.To_Do_App.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    Response createTask(TaskRequestDto taskRequestDto);
    TaskResponseDto editTask(Long taskId, TaskRequestDto taskRequestDto);
    Response updateTaskStatus(Long taskId, StatusUpdateDto status);
    Response updatePriorityLevel(Long taskId, PriorityUpdateDto priority);
    void deleteTask(Long taskId);
    List<TaskResponseDto> getAllTasks();

}
