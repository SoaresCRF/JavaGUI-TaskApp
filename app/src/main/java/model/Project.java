package model;

import java.util.Date;

public final class Project {

    private int id;
    private String name, description;
    private Date createdAt, updatedAt;

    public Project(int id, String name, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Project() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
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

    public final Date getCreatedAt() {
        return createdAt;
    }

    public final void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public final Date getUpdatedAt() {
        return updatedAt;
    }

    public final void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
