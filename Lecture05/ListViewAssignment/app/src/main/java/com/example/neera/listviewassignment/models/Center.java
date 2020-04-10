package com.example.neera.listviewassignment.models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Neera on 28/08/17.
 */

public class Center {
    String location;
    String city;
    String contactnumber;

    public Center(String location, String city, String contactnumber) {
        this.location = location;
        this.city = city;
        this.contactnumber = contactnumber;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    private static String[] locNames = {
            "Pitampura", "Noida", "Model Town", "Dwarka", "New Colony"
    };

    private static String[] cities = {
            "New Delhi", "Gurgaon", "Greater Noida", "Amritsar"
    };

    public static ArrayList<Center> generateCenters(int n) {
        ArrayList<Center> centers = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            Center newCenter = new Center(
                    locNames[r.nextInt(locNames.length)],
                    cities[r.nextInt(cities.length)],
                    String.valueOf(90000000 + r.nextInt(999999))
            );
            centers.add(newCenter);
        }
        return centers;
    }
}
