package com.example.neera.listviews;

/**
 * Created by Neera on 26/08/17.
 */

public class Course {

    String Name;
    String center;
    Integer classes;

    public String getName() {
        return Name;
    }

    public String getCenter() {
        return center;
    }

    public Integer getClasses() {
        return classes;
    }

    public Course(String name, String center, int classes) {
        Name = name;
        this.center = center;
        this.classes = classes;
    }
}
