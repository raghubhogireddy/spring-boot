package io.spring.todoapp.model;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ToDo {
    private int id;
    private String userName;
    
    @Size(min = 10, message = "Enter atleast 10 characters")
    private String description;
    private LocalDate date;
    private boolean completed;

    public ToDo(int id, String userName, String description, LocalDate date, boolean completed) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.date = date;
        this.completed = completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ToDo{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", date=").append(date);
        sb.append(", isCompleted=").append(completed);
        sb.append('}');
        return sb.toString();
    }
}
