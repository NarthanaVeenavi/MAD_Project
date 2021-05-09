package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DonorHome extends AppCompatActivity {
    Button button_donor;
    Button button_health;
    Button button_history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_home);

        button_health = (Button) findViewById(R.id.button_health);
        button_donor = (Button) findViewById(R.id.button_donor) ;
        //button_history = (Button) findViewById(R.id.button_history) ;

        button_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),com.example.home.AddHealthEntry.class);
                startActivity(intent);
            }
        });

        button_donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),com.example.home.DonorEnrollment.class);
                startActivity(intent);

            }
        });

        /*button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),com.example.home.DonorLogin.class);
                startActivity(intent);

            }
        });*/
    }
}