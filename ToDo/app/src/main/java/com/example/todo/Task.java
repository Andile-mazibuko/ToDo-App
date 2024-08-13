package com.example.todo;

public class Task {
    private int color;
    private String title,date,priority;

    public Task(int color, String title, String date, String priority) {
        this.color = color;
        this.title = title;
        this.date = date;
        this.priority = priority;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
