package com.example.resume.projects;

import android.os.Parcel;
import android.os.Parcelable;

public class ProjectModel implements Parcelable {

    private String projectName;
    private String clientName;
    private String projectSummary;
    private String projectDesc;
    private int imageRes;

    /**
     * The constructor for a Project
     * @param projectName the name of a project
     * @param clientName the name of the client for whom the project has been made
     * @param projectSummary a summary of the project, which can be found back in the list of projects
     * @param projectDesc the full description of a project, which can be found back in the detailed view of a project
     * @param imageRes the ID of the image which belongs to this project
     */
    public ProjectModel(String projectName, String clientName, String projectSummary, String projectDesc, int imageRes){
        this.projectName = projectName;
        this.clientName = clientName;
        this.projectSummary = projectSummary;
        this.projectDesc = projectDesc;
        this.imageRes = imageRes;
    }

    /**
     * A constructor for a project, using a parcelable as input
     * @param in a parcelable which contains all the data, in order, for a project
     */
    protected ProjectModel(Parcel in) {
        projectName = in.readString();
        clientName = in.readString();
        projectSummary = in.readString();
        projectDesc = in.readString();
        imageRes = in.readInt();
    }

    /**
     * A method to get the name of a project
     * @return a string containing the name of the project
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * A method to get the name of the client of a project
     * @return a string containing the name of the client
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * A method to get the ID of the image belonging to the project
     * @return an integer which points to the drawable resource file (image) of the project
     */
    public int getImageRes() {
        return imageRes;
    }

    /**
     * A method to get the summary of a project
     * @return a string containing a summary of the project
     */
    public String getProjectSummary() {
        return this.projectSummary;
    }

    /**
     * A method to get the full description of a project
     * @return a string containing the full description of the project
     */
    public String getProjectDesc() {
        return this.projectDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * A method which gets used to save all the data from a Project to a Parcel, which can be used to pass this object to a different fragment
     */
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
