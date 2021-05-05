package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        button2 = (Button) findViewById(R.id.button_patient);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this,Add_Blood_Test.class);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.button_blood_bank);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this,View_Blood_Test.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.button7);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this,Add_Emergency_Notice.class);
                startActivity(intent);
            }
        });

        button5 = (Button) findViewById(R.id.button9);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this,View_Emergency_Notices.class);
                startActivity(intent);
            }
        });
    }
}