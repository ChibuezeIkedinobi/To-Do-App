package com.group2.To_Do_App.controller;

import com.group2.To_Do_App.dto.*;
import com.group2.To_Do_App.dto.payLoadResponse.Response;
import com.group2.To_Do_App.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Response> createTask(@Valid @RequestBody TaskCreationDto taskCreationDto) {
        Response createdTask = taskService.createTask(taskCreationDto);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> editTask(@PathVariable Long taskId,
                                                    @Valid @RequestBody TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.editTask(taskId, taskRequestDto));
    }

    @PatchMapping("/{taskId}/status")
    public ResponseEntity<TaskResponseDto> updateTaskStatus(
            @PathVariable Long taskId,
            @Valid @RequestBody StatusUpdateDto taskStatusUpdateDto) {
        TaskResponseDto task = taskService.updateTaskStatus(taskId, taskStatusUpdateDto.getStatus());
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{taskId}/priority")
    public ResponseEntity<TaskResponseDto> updatePriorityLevel(
            @PathVariable Long taskId,
            @Valid @RequestBody PriorityUpdateDto taskPriorityUpdateDto) {
        TaskResponseDto task = taskService.updatePriorityLevel(taskId, taskPriorityUpdateDto.getPriority());
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        List<TaskResponseDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
}
