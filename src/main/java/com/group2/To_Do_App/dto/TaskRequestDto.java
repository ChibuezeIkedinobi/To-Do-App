package com.group2.To_Do_App.dto;

import com.group2.To_Do_App.emums.PriorityLevel;
import com.group2.To_Do_App.emums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDto {
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private PriorityLevel priority;

    @NotNull
    private TaskStatus status;
}
