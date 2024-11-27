package com.group2.To_Do_App.service.serviceImpl;

import com.group2.To_Do_App.dto.TaskRequestDto;
import com.group2.To_Do_App.dto.TaskResponseDto;
import com.group2.To_Do_App.emums.PriorityLevel;
import com.group2.To_Do_App.emums.TaskStatus;
import com.group2.To_Do_App.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public TaskResponseDto editTask(Long taskId, TaskRequestDto taskRequestDto) {
        return null;
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
