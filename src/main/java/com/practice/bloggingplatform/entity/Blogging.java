package com.practice.bloggingplatform.entity;

import java.time.LocalDateTime;

public class Blogging {
    private int id;
    private String title;
    private String content;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public  void setUpdatedAt(LocalDateTime UpdatedAt) {
        this.updatedAt = UpdatedAt;
    }

    public Blogging(int id, String title, String content, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Title: " + title +
                ", Content: " + content +
                ", Category: " + category+
                ",CreatedAt:" +createdAt+
                ", UpdatedAt:" +updatedAt;
    }
}
