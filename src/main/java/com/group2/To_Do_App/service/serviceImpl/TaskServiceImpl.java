package com.group2.To_Do_App.service.serviceImpl;

import com.group2.To_Do_App.dto.PriorityUpdateDto;
import com.group2.To_Do_App.dto.StatusUpdateDto;
import com.group2.To_Do_App.dto.TaskRequestDto;
import com.group2.To_Do_App.dto.TaskResponseDto;
import com.group2.To_Do_App.dto.payLoadResponse.Response;
import com.group2.To_Do_App.enums.PriorityLevel;
import com.group2.To_Do_App.enums.TaskStatus;
import com.group2.To_Do_App.exception.customException.ResourceNotFoundException;
import com.group2.To_Do_App.model.Task;
import com.group2.To_Do_App.model.User;
import com.group2.To_Do_App.repository.TaskRepository;
import com.group2.To_Do_App.repository.UserRepository;
import com.group2.To_Do_App.security.utils.Util;
import com.group2.To_Do_App.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public Response createTask(TaskRequestDto taskRequestDto) {

        User authenticatedUser = getAuthenticatedUser();

        Task task = Task.builder()
                .title(taskRequestDto.getTitle())
                .description(taskRequestDto.getDescription())
                .priority(PriorityLevel.NONE)
                .status(TaskStatus.PENDING)
                .user(authenticatedUser)
                .build();
        Task newTask = taskRepository.save(task);

        return Response.builder()
                .responseCode(Util.SUCCESS_CODE)
                .responseMessage("Task with ID " + newTask.getId() + " have been created")
                .build();
    }

    @Override
    public TaskResponseDto editTask(Long id, TaskRequestDto taskRequestDto) {

        Task existingTask = taskAvailability(id);

        existingTask.setTitle(taskRequestDto.getTitle());
        existingTask.setDescription(taskRequestDto.getDescription());

        taskRepository.save(existingTask);

        return TaskResponseDto.builder()
                .id(id)
                .title(taskRequestDto.getTitle())
                .description(taskRequestDto.getDescription())
                .priority(existingTask.getPriority())
                .status(existingTask.getStatus())
                .build();
    }

    @Override
    public Response updateTaskStatus(Long taskId, StatusUpdateDto status) {
        Task task = taskAvailability(taskId);
        task.setStatus(validateStatus(status));
        Task updatedTask = taskRepository.save(task);

        return Response.builder()
                .responseCode(Util.SUCCESS_CODE)
                .responseMessage("The Status of the Task with ID " + updatedTask.getId() + " has been Updated")
                .build();
    }

    @Override
    public Response updatePriorityLevel(Long taskId, PriorityUpdateDto priority) {
        Task task = taskAvailability(taskId);
        task.setPriority(validatePriority(priority));
        Task resolvedTask = taskRepository.save(task);

        return Response.builder()
                .responseCode(Util.SUCCESS_CODE)
                .responseMessage("The Priority of the Task with ID " + resolvedTask.getId() + " have been Updated")
                .build();
    }

    @Override
    public Response deleteTask(Long taskId) {
        Task task = taskAvailability(taskId);
        if (task != null){
            taskRepository.delete(task);
            return new Response(Util.SUCCESS_CODE,"Task deleted successfully");
        } else {
            return new Response(Util.NOT_FOUND,"Task not found");
        }

    }

    @Override
    public List<TaskResponseDto> getAllTasks(String status, String priority) {
        TaskStatus taskStatus = (status != null) ? TaskStatus.getStatus(status) : null;
        PriorityLevel priorityLevel = (priority != null) ? PriorityLevel.getPriority(priority) : null;

        List<Task> allTask = taskRepository.findAll();
        if (taskStatus != null){
            allTask = allTask.stream()
                    .filter(task -> task.getStatus().equals(taskStatus))
                    .toList();
        }
        if (priorityLevel != null){
            allTask = allTask.stream()
                    .filter(task -> task.getPriority().equals(priorityLevel))
                    .toList();
        }

        return allTask.stream()
                .map(task -> TaskResponseDto.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .priority(task.getPriority())
                        .status(task.getStatus())
                        .build())
                .toList();
    }

    private User getAuthenticatedUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", email));
    }

    private Task taskAvailability (Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task", id));
    }

    static TaskStatus validateStatus(StatusUpdateDto status){
        return TaskStatus.getStatus(status.getStatus());
    }

    static PriorityLevel validatePriority(PriorityUpdateDto priority){
        return PriorityLevel.getPriority(priority.getPriority());
    }

}
