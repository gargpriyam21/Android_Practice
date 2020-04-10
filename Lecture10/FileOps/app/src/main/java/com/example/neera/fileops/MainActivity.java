package com.example.neera.fileops;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "FILE";

    public static final String FILE_NAME = "myfile.txt";

    TextView tvFileData;
    EditText etNewData;
    Button btnSave, btnRetrieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFileData = (TextView) findViewById(R.id.tvFileData);
        etNewData = (EditText) findViewById(R.id.etNewData);
        btnRetrieve = (Button) findViewById(R.id.btnRetrieve);
        btnSave = (Button) findViewById(R.id.btnSave);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SaveData(etNewData.getText().toString());
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Problem saving file", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    tvFileData.setText(RetrieveData());
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error reading file", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }

    void SaveData(String data) throws IOException {
        File f = new File(getFilesDir(), FILE_NAME);
        FileOutputStream fos = new FileOutputStream(f, true);
        fos.write(("\n" + data).getBytes());
        fos.close();
    }

    String RetrieveData() throws IOException {
        File f = new File(getFilesDir(), FILE_NAME);
        FileInputStream fis = new FileInputStream(f);

        String buf = "";
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        while (buf != null) {
            sb.append(buf + "\n");
            buf = br.readLine();
        }

        return sb.toString();

    }
}
