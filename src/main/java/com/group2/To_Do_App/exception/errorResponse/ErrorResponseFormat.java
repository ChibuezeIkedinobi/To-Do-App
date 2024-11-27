package com.group2.To_Do_App.exception.errorResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponseFormat {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;
    private List<String> message;
    private HttpStatus status;

    public ErrorResponseFormat(List<String> message, HttpStatus status) {
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.status = status;
    }
}
