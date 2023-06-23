package br.com.task.mapper;

import br.com.task.entity.Task;
import br.com.task.entity.enums.Priority;
import br.com.task.resource.request.TaskRequest;
import br.com.task.resource.response.TaskResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskMapper {

    public static Task of(TaskRequest request) {
        return new Task.Builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .createdDate(createdDate(request))
                .editedDate(null)
                .completed(request.isCompleted())
                .priorityLevel(Priority.valueOf(request.getPriorityLevel()))
                .build();
    }

    public static TaskResponse of(Task task) {
        return new TaskResponse.Builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .createdDate(task.getCreatedDate())
                .editedDate(null)
                .completed(task.isCompleted())
                .priorityLevel(task.getPriorityLevel())
                .build();
    }

    private static LocalDateTime createdDate(TaskRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return request.getCreatedDate() != null ?
                LocalDateTime.parse(request.getCreatedDate(), formatter) : LocalDateTime.now();
    }

    public static void requestToUpdateTask(TaskRequest request,Task task) {
        task.setTitle(request.getCreatedDate());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());
        task.setEditedDate(LocalDateTime.now());
    }
}
