package com.example.splityourbills.dto.imageupload;

public class FileInfo {
    private String name;
    private String url;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public FileInfo(String name, String url, String userId) {
        this.name = name;
        this.url = url;
        this.userId = userId;
    }

    public FileInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}