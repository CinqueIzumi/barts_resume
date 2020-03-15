package com.example.resume.education;

import java.util.ArrayList;

public class School {

    private String specialization;
    private String schoolName;
    private String location;
    private String startDate;
    private String endDate;

    /**
     * The constructor which helps generate a school
     * @param specialization The name of the study
     * @param schoolName The name of the scool
     * @param location The location of the school
     * @param startDate The start date
     * @param endDate The end date
     */
    public School(String specialization, String schoolName, String location, String startDate, String endDate) {
        this.specialization = specialization;
        this.schoolName = schoolName;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * A method to get the name of the specialization
     * @return a string value containing the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * A method to get the name of the school
     * @return a string value containing the name of the school
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * A method to get the location of the school
     * @return a string value containing the location of the school
     */
    public String getLocation() {
        return location;
    }

    /**
     * A method to get the duration during which the school has been attended
     * @return a string value containing both the start and the end date
     */
    public String getDuration() {
        String toReturn = startDate + " - " + endDate;
        return toReturn;
    }
}
