package model;

public class ToDoItem {

    private Long id;

    private String title;

    private boolean isDone;

    public ToDoItem(String title, boolean isDone) {
        this.title = title;
        this.isDone = isDone;
    }

    public ToDoItem(Long id, String title, boolean isDone) {
        this.id = id;
        this.title = title;
        this.isDone = isDone;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) { this.title = title; };
    public boolean isDone() {
        return isDone;
    }
    public void setIsDone(boolean isDone) { this.isDone = isDone; }
}