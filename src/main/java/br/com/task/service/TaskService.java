package br.com.task.service;

import br.com.task.entity.Task;
import br.com.task.mapper.TaskMapper;
import br.com.task.repository.TaskRepository;
import br.com.task.resource.request.TaskRequest;
import br.com.task.resource.response.TaskResponse;
import br.com.task.service.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponse> getTasksByCompleted(boolean completed) {
        return taskRepository.findTaskByCompleted(completed).stream()
                .map(TaskMapper::of)
                .collect(Collectors.toList());
    }

    public TaskResponse createTask(TaskRequest request) {
        Task task = TaskMapper.of(request);

        return TaskMapper.of(taskRepository.save(task));
    }

    public void deleteTaskById(String id) {
        taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);

        taskRepository.deleteById(id);
    }

    public TaskResponse updateTask(String id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                        .orElseThrow(TaskNotFoundException::new);

        TaskMapper.requestToUpdateTask(request, task);

        return TaskMapper.of(taskRepository.save(task));
    }
}
