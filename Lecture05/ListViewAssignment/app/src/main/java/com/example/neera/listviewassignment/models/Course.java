package com.example.neera.listviewassignment.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Neera on 28/08/17.
 */

public class Course {
    String Name;
    String teacherName;
    String startDate;
    Integer classes;

    public Course(String name, String teacherName, String startDate, Integer classes) {
        Name = name;
        this.teacherName = teacherName;
        this.startDate = startDate;
        this.classes = classes;
    }

    public String getName() {
        return Name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getStartDate() {
        return startDate;
    }

    public Integer getClasses() {
        return classes;
    }

    private static String[] names = {
            "Pandora", "Crux", "Launchpad", "Elixir", "Algo++"
    };

    private static String[] teachers = {
            "Arnav", "Prateek", "Summet", "Rishabh", "Deepak", "Garima"
    };

    public static ArrayList<Course> generatecourse(int n) {
        ArrayList<Course> courses = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            Course newCourese = new Course(
                    names[r.nextInt(names.length)],
                    teachers[r.nextInt(teachers.length)],
                    r.nextInt(30) + "-09-2017",
                    r.nextInt(5) + 20
            );
            courses.add(newCourese);
        }

        return courses;
    }
}
