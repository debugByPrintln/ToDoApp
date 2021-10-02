package com.melnikov.mainDir.sourceFiles;

import java.time.LocalDateTime;

public class Task {

    private int id;
    private String header;
    private String description;
    private String creationDateTime;
    private String toDoDateTime;


    public Task() {

    }

    @Override
    public String toString() {
        return id + ", '"
                + header + "', '"
                + description + "', '"
                + creationDateTime + "', '"
                + toDoDateTime + "'";
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public String getToDoDateTime() {
        return toDoDateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setToDoDateTime(String toDoDateTime) {
        this.toDoDateTime = toDoDateTime;
    }
}
