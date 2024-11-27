package com.group2.To_Do_App.dto;

import com.group2.To_Do_App.emums.PriorityLevel;
import com.group2.To_Do_App.emums.TaskStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskResponseDto {

    private Long id;
    private String title;
    private String description;
    private PriorityLevel priority;
    private TaskStatus status;

}
