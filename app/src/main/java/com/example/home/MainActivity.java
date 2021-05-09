package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void patientFunction(View view){
        Intent i = new Intent(this, PatientHome.class);
        startActivity(i);
        Toast toast = Toast.makeText(getApplicationContext(),"Welcome to the Patient Section!",Toast.LENGTH_LONG);
        toast.show();
    }
}