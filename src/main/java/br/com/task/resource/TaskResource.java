package br.com.task.resource;

import br.com.task.resource.request.TaskRequest;
import br.com.task.resource.response.TaskResponse;
import br.com.task.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@Tag(name = "Tasks", description = "Operações relacionadas a tarefas")
public class TaskResource {

    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Filtrar tarefas pelo status de finalização")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao encontrar tarefas"),
            @ApiResponse(responseCode = "404", description = "Tarefas não encontradas")
    })
    @GetMapping("/{completed}")
    public List<TaskResponse> getTasksByCompleted(@PathVariable @Parameter(description = "Status de conclusão da tarefa") boolean completed) {
        return taskService.getTasksByCompleted(completed);
    }

    @Operation(summary = "Criar uma nova tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody @Validated @Parameter(description = "Detalhes da nova tarefa") TaskRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(request));
    }

    @Operation(summary = "Deletar tarefa por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable @Parameter(description = "ID da tarefa a ser deletada") String id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Atualizar uma tarefa existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable @Parameter(description = "ID da tarefa a ser atualizada") String id,
                                   @RequestBody @Validated @Parameter(description = "Detalhes da tarefa a ser atualizada") TaskRequest  request) {
        return taskService.updateTask(id, request);
    }
}
