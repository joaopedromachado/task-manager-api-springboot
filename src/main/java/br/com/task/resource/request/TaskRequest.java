package br.com.task.resource.request;

public class TaskRequest {

    private String title;
    private String description;
    private String createdDate;
    private boolean completed;
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
