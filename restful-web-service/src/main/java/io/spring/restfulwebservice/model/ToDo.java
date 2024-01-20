package io.spring.restfulwebservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class ToDo implements Comparable<ToDo>{
    
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    
    @Size(min = 10, message = "Enter atleast 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean completed;

    public ToDo() {
    }

    public ToDo(int id, String userName, String description, LocalDate targetDate, boolean completed) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
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

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
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

    public LocalDate getTargetDate() {
        return targetDate;
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
        sb.append(", date=").append(targetDate);
        sb.append(", isCompleted=").append(completed);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(ToDo o) {
        return Integer.compare(this.id, o.getId());
    }
}
