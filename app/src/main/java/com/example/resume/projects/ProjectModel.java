package com.example.resume.projects;

public class ProjectModel {

    private String projectName;
    private String clientName;
    int id_;

    public ProjectModel(String projectName, String clientName, int id_) {
        this.projectName = projectName;
        this.clientName = clientName;
        this.id_ = id_;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }
}
