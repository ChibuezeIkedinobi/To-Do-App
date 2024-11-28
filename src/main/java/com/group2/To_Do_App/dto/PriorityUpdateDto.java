package com.group2.To_Do_App.dto;

import com.group2.To_Do_App.enums.PriorityLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriorityUpdateDto {

    @NotBlank(message = "Priority level should not be blank")
    private String priority;


}
