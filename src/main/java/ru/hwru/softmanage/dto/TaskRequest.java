package ru.hwru.softmanage.dto;

import ru.hwru.softmanage.entity.Project;
import ru.hwru.softmanage.entity.User;
import ru.hwru.softmanage.enums.TaskStatus;

import java.time.LocalDate;

public class TaskRequest {

    private String title;
    private String description;

    private TaskStatus status;     // позже можно заменить на enum
    private String priority;   // тоже можно потом в enum

    private LocalDate deadline;

    private Project project;
    private User assigned;


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

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getAssigned() {
        return assigned;
    }

    public void setAssigned(User assigned) {
        this.assigned = assigned;
    }
}
