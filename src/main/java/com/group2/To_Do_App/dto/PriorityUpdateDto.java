package com.group2.To_Do_App.dto;

import com.group2.To_Do_App.emums.PriorityLevel;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PriorityUpdateDto {

    @NotNull
    private PriorityLevel priority;

}
