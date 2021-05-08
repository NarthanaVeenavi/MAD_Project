package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PatientHome extends AppCompatActivity {

    Button btnOpenReq, btnNewReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenReq = findViewById(R.id.btnOpenReq);
        btnOpenReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientHome.this,reqPage.class);
                startActivity(intent);
            }
        });

        btnNewReq = findViewById(R.id.button);
        btnNewReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientHome.this,newReq.class);
                startActivity(intent);
            }
        });
    }

}