package com.codingblocks.testingcoverage;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by arnav on 10/2/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    public MainActivity mainActivity;
    @Rule
    public ActivityTestRule<MainActivity> mainActRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void startActivity () {
        mainActivity = mainActRule.getActivity();
    }

    @Test
    public void calcFareWorksOnUi () {
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                testCalcFareWithKmAndMin("0", "0", "50.0");
                testCalcFareWithKmAndMin("10", "0", "110.0");
                testCalcFareWithKmAndMin("0", "30", "65.0");
                testCalcFareWithKmAndMin("10", "30", "125.0");

            }
        });
    }

    void testCalcFareWithKmAndMin(String km, String min, String expResult) {
        ((EditText) mainActivity.findViewById(R.id.etKm)).setText(km);
        ((EditText) mainActivity.findViewById(R.id.etMin)).setText(min);
        ((Button) mainActivity.findViewById(R.id.btnCalcFare)).performClick();
        String result = ((TextView) mainActivity.findViewById(R.id.tvResult)).getText().toString();

        assertEquals(expResult, result);
    }
}
