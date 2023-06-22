package br.com.task.service.exception;

public class TaskNotFoundException extends RuntimeException {
    private static final String msg = "Tarefa não encontrada";
    public TaskNotFoundException() {
        super(msg);
    }
}
