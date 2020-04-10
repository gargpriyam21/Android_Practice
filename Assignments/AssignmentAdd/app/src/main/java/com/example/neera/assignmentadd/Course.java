package com.example.neera.assignmentadd;

import java.util.ArrayList;

/**
 * Created by Neera on 30/08/17.
 */

public class Course {
    String Name;
    String Teacher;
    Integer Classes;

    public Course(String name, String teacher, Integer classes) {
        Name = name;
        Teacher = teacher;
        Classes = classes;
    }

    public String getName() {
        return Name;
    }

    public String getTeacher() {
        return Teacher;
    }

    public Integer getClasses() {
        return Classes;
    }

    public static void generate(ArrayList<Course> courses) {
        courses.add(new Course("Course", "Teacher", 22));
        courses.add(new Course("Course", "Teacher", 22));
        courses.add(new Course("Course", "Teacher", 22));
        courses.add(new Course("Course", "Teacher", 22));
        courses.add(new Course("Course", "Teacher", 22));
        courses.add(new Course("Course", "Teacher", 22));
        courses.add(new Course("Course", "Teacher", 22));
        courses.add(new Course("Course", "Teacher", 22));
        courses.add(new Course("Course", "Teacher", 22));
        courses.add(new Course("Course", "Teacher", 22));
    }


}
