package me.rishabhkhanna.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG  = "MainActivity";
    SensorManager sensorManager;
    Sensor accelSensor;
    SensorEventListener sensorEventListener;
    Sensor proxySensor;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        List<Sensor> sensorsList = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);


        accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        proxySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                    relativeLayout.setBackgroundColor(Color.rgb(
                            getColor(event.values[0]),
                            getColor(event.values[1]),
                            getColor(event.values[2])
                    ));
                }

                if(event.sensor.getType() == Sensor.TYPE_PROXIMITY){
                    Log.d(TAG, "onSensorChanged: " + event.values[0]);
                    if(event.values[0] == proxySensor.getMaximumRange()) {
                        relativeLayout.setBackgroundColor(Color.BLACK);
                    }else {
                        relativeLayout.setBackgroundColor(Color.WHITE);
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

//        for(Sensor sensor : sensorsList){
//            Log.d(TAG, "onCreate: " + sensor.getName());
//            Log.d(TAG, "onCreate: " + sensor.getVendor());
//            Log.d(TAG, "onCreate: " + sensor.getVersion());
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
//                Log.d(TAG, "onCreate: " + sensor.getStringType());
//            }
//            Log.d(TAG, "--------------------------------------------------");
//        }
    }

    @Override
    protected void onResume() {
        sensorManager.registerListener(sensorEventListener,accelSensor,1000 * 1000);
        sensorManager.registerListener(sensorEventListener,proxySensor,1000 * 1000);
        super.onResume();
    }

    @Override
    protected void onPause() {
        sensorManager.unregisterListener(sensorEventListener);
        super.onPause();
    }

    public int getColor(float value){
        value = value + 12;
        return (int)(value/24 * 255);
    }

}
