package com.example.resume.projects;

import com.example.resume.R;

import java.util.ArrayList;

public class ProjectFactory {
    private ArrayList<ProjectModel> projects;
    private String client_avans = "Avans University of Applied Sciences";
    private String client_personal = "Personal";

    /**
     * The constructor of the project factory
     */
    public ProjectFactory() {
        projects = new ArrayList<>();
    }

    /**
     * A method which gets used to create all the past projects, which will later be displayed in the app
     * @return an arraylist of projects
     */
    public ArrayList<ProjectModel> createProjects() {
        projects.add(new ProjectModel("CV App", client_personal, "An app which functions as my resume.",
                "My resume in app form. Everything that can be found on my resume, can also be found in this app. This project can be found on my github.", R.drawable.poggers));
        projects.add(new ProjectModel("Proftaak - Mobile Guiding System", client_avans, "A Mobile Guiding System, which allows the user to follow a pre-set route through a city.",
                "A mobile application, which uses GPS to locate the user. The purpose of the app is to generate a walkable route. This route goes through Breda, and will lead you" +
                        " to different, pre-set waypoints. These waypoints have their own markings on the map, and can be things such as restaurants, statues etc. This app was made in Android Studio.",
                R.drawable.mgs));
        projects.add(new ProjectModel("Proftaak - Remote Health Care", client_avans, "A project aimed at helping doctors monitor their clients while they're cycling in a VR setting.",
                "A windows forms application made using C#, that exists out of the following sub-applications: a doctor's application, a patient's application and a server. " +
                        "The doctor can use their client to monitor the patient's details, such as their heartbeat, the current resistance on their bike, etc. The doctor can communicate with " +
                        "their client, by sending a message to their VR environment. The doctor is also able to change the settings of the patient's VR cycle session, by changing the resistance " +
                        "or stopping the session. The client can see information regarding their cycle session in the VR environment. All the aforementioned data gets saved on a server, which uses" +
                        " encryption.", R.drawable.remote_health_care));
        projects.add(new ProjectModel("Proftaak - Pepper Robot", client_avans, "The programming of a Pepper Robot, which helps humans book a table in a restaurant.",
                "The programming of a Pepper Robot, which uses facial recognition. The Pepper Robot will greet approaching people, after which the customers can book a table " +
                        "using either speech or the tablet which can be found on the torso of the robot.", R.drawable.pepper));
        projects.add(new ProjectModel("Proftaak - School Planner", client_avans, "A school-simulator, which uses data from a custom roster to simulate the classes.",
                "The programming of a JavaFX screen, which displays the simulation of a school. In the school there are classrooms and walking students (sprites). There was " +
                        "a clock, which helped with managing the roster. Once it was time for a new class, according to the clock, the students would go to their new classes. The data for " +
                        "this simulation has been made in a customizable Roster class, which has a seperate UI for editing. This application was made using Java.", R.drawable.temp));
        projects.add(new ProjectModel("Proftaak - Boebot", client_avans, "A BoE-bot which is able to navigate through a route without colliding with obstacles.",
                "The programming of a so-called Board of Education Bot (BoE Bot). The boebot had several requirements, including the following: " +
                        "\n1. The Robot has to be able to ride around without colliding." +
                        "\n2. The robot has to be able to follow a black line. " +
                        "\n3. The robot has to be able to be controlled from a distance using either bluetooth or infrared (a tv remote)." +
                        "\n4. There also has to be the option to define a route beforehand, which the robot would then follow (along a black line). " +
                        "\nThis robot was programmed using Java.", R.drawable.boebot));
        projects.add(new ProjectModel("Proftaak - Internet Weatherstation", client_avans, "An Internet Weatherstation which displays values in a GUI which get pulled and converted from a database.",
                "An internet weatherstation, which uses an online accessible database and a physical weatherstation. We had to obtain the values recorded by the weatherstation " +
                        "from the database, after which we had to convert these values to the types that are used in The Netherlands (f.e Fahrenheit to Celsius). These values had to be " +
                        "saved again, after which we had to display them on a virtual GUI. This application was made using Java.", R.drawable.iw));
        return projects;
    }
}
