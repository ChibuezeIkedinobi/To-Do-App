package com.group2.To_Do_App.exception.errorResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponseFormat {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;
    private List<String> message;

    public ErrorResponseFormat(List<String> message) {
        this.timeStamp = LocalDateTime.now();
        this.message = message;
    }
}
