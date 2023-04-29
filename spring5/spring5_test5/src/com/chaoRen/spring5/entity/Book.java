package com.chaoRen.spring5.entity;

import org.springframework.lang.Nullable;

public class Book {
    @Nullable
    private String userId;
    private String username;
    private String status;

    public Book() {
    }

    public Book(String userId, String username, String status) {
        this.userId = userId;
        this.username = username;
        this.status = status;
    }

    @Nullable
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
