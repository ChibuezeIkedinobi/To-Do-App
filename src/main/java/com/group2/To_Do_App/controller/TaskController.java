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
    public ResponseEntity<Response> createTask(@Valid @RequestBody TaskRequestDto taskRequestDto) {
        Response createdTask = taskService.createTask(taskRequestDto);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> editTask(@PathVariable Long taskId,
                                                    @Valid @RequestBody TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.editTask(taskId, taskRequestDto));
    }

    @PatchMapping("/{taskId}/status")
    public ResponseEntity<Response> updateTaskStatus(@PathVariable Long taskId,
                                                     @Valid @RequestBody StatusUpdateDto taskStatusUpdateDto) {
        return ResponseEntity.ok(taskService.updateTaskStatus(taskId, taskStatusUpdateDto));
    }

    @PatchMapping("/{taskId}/priority")
    public ResponseEntity<Response> updatePriorityLevel(@PathVariable Long taskId,
                                                        @Valid @RequestBody PriorityUpdateDto taskPriorityUpdateDto) {
        return ResponseEntity.ok(taskService.updatePriorityLevel(taskId, taskPriorityUpdateDto));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Response> deleteTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.deleteTask(taskId));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks(@RequestParam(required = false) String status,
                                                             @RequestParam(required = false) String priority) {
        List<TaskResponseDto> tasks = taskService.getAllTasks(status, priority);
        return ResponseEntity.ok(tasks);
    }
}
