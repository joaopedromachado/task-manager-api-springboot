package br.com.task.service.exception;

public class TaskDeletionException extends RuntimeException {
    private static final String msg = "Erro ao executar a anotação do @Scheduled para deletar a tarefa";
    public TaskDeletionException() {
        super(msg);
    }
}
