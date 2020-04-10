package com.example.neera.fragmentassignment;

/**
 * Created by Neera on 28/09/17.
 */

public class Model {
    String Name, College;
    Integer Age;

    public Model(String name, String college, Integer age) {
        Name = name;
        College = college;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public String getCollege() {
        return College;
    }

    public Integer getAge() {
        return Age;
    }
}
