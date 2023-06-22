package br.com.task.service;

import br.com.task.entity.Task;
import br.com.task.repository.TaskRepository;
import br.com.task.service.exception.TaskDeletionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class SchedulerService {

    private final TaskRepository taskRepository;

    public SchedulerService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void deleteOldTasksCompleted() {
        try {
            List<Task> tasksToBeDeleted = getOldTasksCompleted();
            taskRepository.deleteAll(tasksToBeDeleted);
            log.info("Tarefas sendo deletadas: " + tasksToBeDeleted);
        } catch (TaskDeletionException e) {

            throw e;
        }
    }

    private List<Task> getOldTasksCompleted() {
        LocalDateTime date = LocalDateTime.now().minusDays(10);

        return taskRepository.findOldTasksCompletedThan(date);
    }
}
