package br.com.task.config;

import br.com.task.resource.exception.StandardError;
import br.com.task.service.exception.TaskNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerException {

    @ExceptionHandler({TaskNotFoundException.class})
    public ResponseEntity<Void> handlerArgsNotFoundException() {
        // TODO Implementar handler
        return null;
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<StandardError> globalHandlerArgsException() {
        // TODO Implementar handler
        return null;
    }
}
