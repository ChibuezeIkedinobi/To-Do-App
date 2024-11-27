package com.group2.To_Do_App.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import com.group2.To_Do_App.enums.PriorityLevel;
import com.group2.To_Do_App.enums.TaskStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {

    private Long id;
    private String title;
    private String description;
    private PriorityLevel priority;
    private TaskStatus status;

}
