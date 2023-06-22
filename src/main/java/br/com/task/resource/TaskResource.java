package br.com.task.resource;

import br.com.task.resource.request.TaskRequest;
import br.com.task.resource.response.TaskResponse;
import br.com.task.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskResource {

    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("{completed}")
    public List<TaskResponse> getTasksByCompleted(@PathVariable boolean completed) {
        return taskService.getTasksByCompleted(completed);
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable String id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public TaskResponse updateTask(@PathVariable String id, @RequestBody TaskRequest  request) {
        return taskService.updateTask(id, request);
    }
}
