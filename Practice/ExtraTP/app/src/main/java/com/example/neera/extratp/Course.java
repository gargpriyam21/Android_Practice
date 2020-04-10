package com.example.neera.extratp;

/**
 * Created by Neera on 08/09/17.
 */

public class Course {
    String Course;
    String Teacher;
    Integer Classes;

    public Course(String course, String teacher, Integer classes) {
        Course = course;
        Teacher = teacher;
        Classes = classes;
    }

    public String getCourse() {
        return Course;
    }

    public String getTeacher() {
        return Teacher;
    }

    public Integer getClasses() {
        return Classes;
    }
}
