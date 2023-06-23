package br.com.task.config;

import br.com.task.resource.exception.StandardError;
import br.com.task.service.exception.TaskDeletionException;
import br.com.task.service.exception.TaskNotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Configuration
@ControllerAdvice
public class ErrorHandlerException {

    @ExceptionHandler(value = {TaskNotFoundException.class, TaskDeletionException.class})
    public ResponseEntity<StandardError> handlerArgsNotFoundException(TaskNotFoundException e, WebRequest request) {
        StandardError error = new StandardError.Builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(System.currentTimeMillis())
                .message(e.getMessage())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<StandardError> globalHandlerArgsException(Exception e) {
        StandardError error = new StandardError.Builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(System.currentTimeMillis())
                .message(e.getMessage())
                .path(e.getClass().getPackageName())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
