package model;

import java.util.Date;

public final class Task {

    private int id, idProject;
    private String name, description, notes;
    private boolean isCompleted;
    private Date deadline, createdAt, updatedAt;

    public Task(int id, int idProject, String name, String description, String notes, boolean isCompleted, Date deadline, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final int getIdProject() {
        return idProject;
    }

    public final void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final String getNotes() {
        return notes;
    }

    public final void setNotes(String notes) {
        this.notes = notes;
    }

    public final boolean isIsCompleted() {
        return isCompleted;
    }

    public final void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public final Date getDeadline() {
        return deadline;
    }

    public final void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public final Date getCreatedAt() {
        return createdAt;
    }

    public final void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public final Date getUpdatedAt() {
        return updatedAt;
    }

    public final void setUpdatedAt(Date updateAt) {
        this.updatedAt = updateAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", notes=" + notes + ", isCompleted=" + isCompleted + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updateAt=" + updatedAt + '}';
    }
}
