package com.example.resume.projects;

import android.os.Parcel;
import android.os.Parcelable;

public class ProjectModel implements Parcelable {

    private String projectName;
    private String clientName;
    private String projectSummary;
    private String projectDesc;
    private int imageRes;

    public ProjectModel(String projectName, String clientName, String projectSummary, String projectDesc, int imageRes){
        this.projectName = projectName;
        this.clientName = clientName;
        this.projectSummary = projectSummary;
        this.projectDesc = projectDesc;
        this.imageRes = imageRes;
    }

    protected ProjectModel(Parcel in) {
        projectName = in.readString();
        clientName = in.readString();
        projectSummary = in.readString();
        projectDesc = in.readString();
        imageRes = in.readInt();
    }

    public String getProjectName() {
        return projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getProjectSummary() {
        return this.projectSummary;
    }

    public String getProjectDesc() {
        return this.projectDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(projectName);
        dest.writeString(clientName);
        dest.writeString(projectSummary);
        dest.writeString(projectDesc);
        dest.writeInt(imageRes);
    }

    public static final Parcelable.Creator<ProjectModel> CREATOR = new Parcelable.Creator<ProjectModel>() {
        public ProjectModel createFromParcel(Parcel source) {
            return new ProjectModel(source);
        }

        public ProjectModel[] newArray(int size) {
            return new ProjectModel[size];
        }
    };
}
