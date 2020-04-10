package com.example.neera.fragmentpractise;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    boolean status = false;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getFragmentManger didn't work instead getSupportFragmentManager worked(DOUBT)***********
                //FragmentManager fragmentManager = getFragmentManager();
                //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (!status) {
                    FragmentOne f1 = new FragmentOne();
                    //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, f1).commit();
                    fragmentTransaction.add(R.id.fragment_container, f1, "HELLO");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    btn.setText("LOAD SECOND FRAGMENT");
                    status = true;
                } else {
                    FragmentTwo f2 = new FragmentTwo();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, f2).commit();
                    /*fragmentTransaction.add(R.id.fragment_container, f2);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();*/
                    btn.setText("LOAD FIRST FRAGMENT");
                    status = false;
                }
            }
        });
    }
}