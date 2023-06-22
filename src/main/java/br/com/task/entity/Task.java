package br.com.task.entity;

import br.com.task.entity.enums.Priority;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "task_manager_collection")
public class Task {

    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime editedDate;
    private boolean completed;
    private Priority priorityLevel;

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", editedDate=" + editedDate +
                ", completed=" + completed +
                ", priorityLevel=" + priorityLevel +
                '}';
    }

    public Task(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.createdDate = builder.createdDate;
        this.editedDate = builder.editedDate;
        this.completed = builder.completed;
        this.priorityLevel = builder.priorityLevel;
    }

    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(LocalDateTime editedDate) {
        this.editedDate = editedDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Priority getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Priority priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public static class Builder {
        private String id;
        private String title;
        private String description;
        private LocalDateTime createdDate;
        private LocalDateTime editedDate;
        private boolean completed;
        private Priority priorityLevel;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder editedDate(LocalDateTime editedDate) {
            this.editedDate = editedDate;
            return this;
        }

        public Builder completed(boolean completed) {
            this.completed = completed;
            return this;
        }

        public Builder priorityLevel(Priority priorityLevel) {
            this.priorityLevel = Priority.valueOf(priorityLevel.getLevel());
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

}
