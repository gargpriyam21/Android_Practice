package com.codingblocks.testingcoverage;

/**
 * Created by arnav on 10/2/2017.
 */
import org.junit.Test;

import static org.junit.Assert.*;
import static com.codingblocks.testingcoverage.MainActivity.*;

public class MainActivityTest {

    @Test
    public void calcFareWorks () {
        assertEquals(50, calcFare(0, 0), 0.001);
    }
}

