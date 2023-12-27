package com.thinhnee.loginpagedemo.entity;

public class Image {
    private int id;
    private String imageFileName;
    private String username;

    public Image() {
    }

    public Image(int id, String imageFileName, String username) {
        this.id = id;
        this.imageFileName = imageFileName;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", imageFileName='" + imageFileName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
