package com.group2.To_Do_App.enums;

import com.group2.To_Do_App.exception.customException.InvalidInputException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@AllArgsConstructor
public enum TaskStatus {

    PENDING("pending"),
    IN_PROGRESS("in_progress"),
    COMPLETED("completed");

    @Getter
    @Setter
    private String message;

    private static HashMap<String,TaskStatus> currentStatus = new HashMap<>();

    static {
        for (TaskStatus status : values()){
            currentStatus.put(status.getMessage().toLowerCase(), status);
        }
    }

    public static TaskStatus getStatus(String status){
        TaskStatus currentStatus1 = currentStatus.get(status.toLowerCase());
        if(currentStatus1 != null) {
            return currentStatus1;
        }
        throw new InvalidInputException("The input is invalid");
    }
}
