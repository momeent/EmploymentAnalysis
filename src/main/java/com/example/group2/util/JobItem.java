package com.example.group2.util;

public class JobItem {
    private int jobItemId;
    private String title;
    private String description;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getJobItemId() {
        return jobItemId;
    }

    public void setJobItemId(int jobItemId) {
        this.jobItemId = jobItemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JobItem{" +
                "jobItemId=" + jobItemId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public JobItem() {
    }

    public JobItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public JobItem(int jobItemId, String title, String description) {
        this.jobItemId = jobItemId;
        this.title = title;
        this.description = description;
    }

    public JobItem(int jobItemId, String title, String description, String url) {
        this.jobItemId = jobItemId;
        this.title = title;
        this.description = description;
        this.url = url;
    }
}
