package br.com.task.resource.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TaskRequest {

    @NotBlank(message = "O campo não pode estar em branco.")
    private String title;
    private String description;
    private String createdDate;
    private boolean completed;
    @NotNull(message = "O campo não pode ser nulo.")
    private int priorityLevel;

    public TaskRequest() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }
}
