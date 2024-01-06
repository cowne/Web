package com.thinhnee.model.note;

public class Note {
    private int id;
    private String content;
    private String username;

    public Note() {
    }

    public Note(int id, String content, String username) {
        this.id = id;
        this.content = content;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
