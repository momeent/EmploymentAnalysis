package com.example.group2.util;

public class Project {
    private String project_time;
    private String project_name;
    private String role;
    private String project_description;
    private String project_performance;
    private String project_link;

    public String getProject_time() {
        return project_time;
    }

    public void setProject_time(String project_time) {
        this.project_time = project_time;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getProject_performance() {
        return project_performance;
    }

    public void setProject_performance(String project_performance) {
        this.project_performance = project_performance;
    }

    public String getProject_link() {
        return project_link;
    }

    public void setProject_link(String project_link) {
        this.project_link = project_link;
    }

    public Project() {
    }

    public Project(String project_time, String project_name, String role, String project_description, String project_performance, String project_link) {
        this.project_time = project_time;
        this.project_name = project_name;
        this.role = role;
        this.project_description = project_description;
        this.project_performance = project_performance;
        this.project_link = project_link;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_time='" + project_time + '\'' +
                ", project_name='" + project_name + '\'' +
                ", role='" + role + '\'' +
                ", project_description='" + project_description + '\'' +
                ", project_performance='" + project_performance + '\'' +
                ", project_link='" + project_link + '\'' +
                '}';
    }
}
