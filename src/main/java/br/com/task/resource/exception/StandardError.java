package br.com.task.resource.exception;

import java.time.LocalDateTime;

public class StandardError {

    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String path;
}
