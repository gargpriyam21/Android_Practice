package com.example.neera.lva2.Models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Neera on 29/08/17.
 */

public class Center {
    String Location;
    String City;
    String ContactNumber;

    public Center(String location, String city, String contactNumber) {
        Location = location;
        City = city;
        ContactNumber = contactNumber;
    }

    public String getLocation() {
        return Location;
    }

    public String getCity() {
        return City;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public static String[] locations = {
            "Pitampura", "Noida", "Model Town", "Dwarka", "New Colony"
    };

    public static String[] cities = {
            "New Delhi", "Gurgaon", "Greater Noida", "Amritsar"
    };


    public static ArrayList<Center> generateCenters(int n) {
        ArrayList<Center> centers = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            Center newCenter = new Center(
                    locations[r.nextInt(locations.length)],
                    cities[r.nextInt(cities.length)],
                    String.valueOf(980000000 + r.nextInt(9999999))
            );
            centers.add(newCenter);

        }
        return centers;

    }
}
