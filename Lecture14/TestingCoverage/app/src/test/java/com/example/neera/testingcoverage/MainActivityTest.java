package com.example.neera.testingcoverage;

/**
 * Created by Neera on 02/10/17.
 */

import org.junit.Test;

import static com.example.neera.testingcoverage.MainActivity.calcFare;
import static org.junit.Assert.assertEquals;

public class MainActivityTest {


    @Test
    public void calcFareWorks() {
        assertEquals(65, calcFare(0, 30), 0.001);
    }
}
