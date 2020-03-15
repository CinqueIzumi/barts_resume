package com.example.resume.education;

import java.util.ArrayList;

public class SchoolFactory {

    private ArrayList<School> schools;

    /**
     * The constructor of the factory
     */
    public SchoolFactory() {
        this.schools = new ArrayList<>();
    }

    /**
     * A method which will create all the different school which have been attended
     * @return an Arraylist with School objects
     */
    public ArrayList<School> createSchools() {
        this.schools.add(new School("B.Sc. - Computer Science", "Avans University of Applied Sciences", "Breda", "Sept 2018", "Ongoing"));
        return this.schools;
    }
}
