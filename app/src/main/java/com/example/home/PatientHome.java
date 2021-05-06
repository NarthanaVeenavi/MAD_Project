package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PatientHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
    }

    public void newReq(View view){
        Intent i = new Intent(this, newReq.class);
        startActivity(i);
       }


    public void openReq(View view){
        Intent i = new Intent(this, reqPage.class);
        startActivity(i);
       }

    public void openRes(View view){
        Intent i = new Intent(this, donorResPage.class);
        startActivity(i);
        }
}