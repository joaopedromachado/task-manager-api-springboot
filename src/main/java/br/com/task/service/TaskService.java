package br.com.task.service;

import br.com.task.entity.Task;
import br.com.task.mapper.TaskMapper;
import br.com.task.repository.TaskRepository;
import br.com.task.resource.request.TaskRequest;
import br.com.task.resource.response.TaskResponse;
import br.com.task.service.exception.TaskNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        log.info("Iniciando TaskService com o repositório: {}", taskRepository);
    }

    public List<TaskResponse> getTasksByCompleted(boolean completed) {
        log.info("Buscando tarefas com status de conclusão: {}", completed);
        List<TaskResponse> tasks = taskRepository.findTaskByCompleted(completed).stream()
                .map(TaskMapper::of)
                .collect(Collectors.toList());
        log.info("Encontrado {} tarefas com status de conclusão: {}", tasks.size(), completed);
        return tasks;
    }

    public TaskResponse createTask(TaskRequest request) {
        log.info("Criando uma nova tarefa: {}", request);
        Task task = TaskMapper.of(request);
        TaskResponse response = TaskMapper.of(taskRepository.save(task));
        log.info("Tarefa criada com sucesso: {}", response);
        return response;
    }

    public void deleteTaskById(String id) {
        log.info("Deletando a tarefa com ID: {}", id);
        taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);

        taskRepository.deleteById(id);
        log.info("Tarefa com ID {} deletada com sucesso", id);
    }

    public TaskResponse updateTask(String id, TaskRequest request) {
        log.info("Atualizando a tarefa com ID: {}", id);
        Task task = taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);

        TaskMapper.requestToUpdateTask(request, task);
        TaskResponse response = TaskMapper.of(taskRepository.save(task));
        log.info("Tarefa com ID {} atualizada com sucesso: {}", id, response);
        return response;
    }
}
