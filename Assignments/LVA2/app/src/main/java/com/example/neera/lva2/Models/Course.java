package com.example.neera.lva2.Models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Neera on 29/08/17.
 */

public class Course {

    String Name;
    String Teacher;
    String Date;
    Integer Classes;

    public Course(String name, String teacher, String date, Integer classes) {
        Name = name;
        Teacher = teacher;
        Date = date;
        Classes = classes;
    }

    public String getName() {
        return Name;
    }

    public String getTeacher() {
        return Teacher;
    }

    public String getDate() {
        return Date;
    }

    public Integer getClasses() {
        return Classes;
    }

    public static String[] names = {
            "Pandora", "Crux", "Launchpad", "Elixir", "Algo++"
    };

    public static String[] teachers = {
            "Arnav", "Prateek", "Summet", "Rishabh", "Deepak", "Garima"
    };

    public static ArrayList<Course> generateCourses(int n) {
        ArrayList<Course> courses = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            Course newCourse = new Course(
                    names[r.nextInt(names.length)],
                    teachers[r.nextInt(teachers.length)],
                    r.nextInt(30) + "-09-2017",
                    r.nextInt(5) + 20
            );
            courses.add(newCourse);
        }


        return courses;
    }
}
