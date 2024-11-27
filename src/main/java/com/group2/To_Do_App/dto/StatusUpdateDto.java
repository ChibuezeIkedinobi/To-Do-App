package com.group2.To_Do_App.dto;

import com.group2.To_Do_App.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatusUpdateDto {

    @NotNull
    private TaskStatus status;

}
