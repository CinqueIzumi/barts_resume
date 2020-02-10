package com.example.resume;

import java.util.ArrayList;

public class ProjectFactory {
    private ArrayList<ProjectModel> projects;
    private String client_avans = "Avans University of Applied Sciences";
    private String client_personal = "Personal";

    public ProjectFactory() {
        projects = new ArrayList<>();
    }

    public ArrayList<ProjectModel> createProjects() {

        projects.add(new ProjectModel("Proftaak - Mobile Guiding System", client_avans, 1));
        projects.add(new ProjectModel("Proftaak - Remote Health Care", client_avans, 2));
        projects.add(new ProjectModel("Proftaak - Pepper Robot", client_avans, 3));
        projects.add(new ProjectModel("Proftaak - School Planner", client_avans, 4));
        projects.add(new ProjectModel("Proftaak - Boebot", client_avans, 5));
        projects.add(new ProjectModel("Proftaak - Internet Weatherstation", client_avans, 6));
        return projects;
    }
}
