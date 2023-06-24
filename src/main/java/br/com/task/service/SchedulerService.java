package br.com.task.service;

import br.com.task.entity.Task;
import br.com.task.repository.TaskRepository;
import br.com.task.service.exception.TaskDeletionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class SchedulerService {

    private final TaskRepository taskRepository;

    public SchedulerService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        log.info("Iniciando o SchedulerService com o repositório: {}", taskRepository);
    }

    public void deleteOldTasksCompleted() {
        try {
            log.info("Iniciando a deleção de tarefas antigas completas");
            List<Task> tasksToBeDeleted = getOldTasksCompleted();
            log.info("Tarefas para serem deletadas: {}", tasksToBeDeleted);
            taskRepository.deleteAll(tasksToBeDeleted);
            log.info("Deletando as tarefas: {}", tasksToBeDeleted);
        } catch (TaskDeletionException e) {
            log.error("Erro na deleção de tarefas antigas completas: {}", e.getMessage());
            throw e;
        }
    }

    private List<Task> getOldTasksCompleted() {
        LocalDateTime date = LocalDateTime.now().minusDays(10);
        log.info("Buscando tarefas completas mais antigas que: {}", date);
        List<Task> oldTasks = taskRepository.findOldTasksCompletedThan(date);
        log.info("Tarefas antigas completas encontradas: {}", oldTasks);
        return oldTasks;
    }

    public void cleanLogs() throws IOException {
        File file = new File("logs.log");

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            throw e;
        }
    }
}
