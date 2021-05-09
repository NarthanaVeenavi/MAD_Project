package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cus_View extends AppCompatActivity {

    Button skip, blood_banks, emergency_notices, blood_tests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus__view);

        skip = findViewById(R.id.button);
        blood_banks = findViewById(R.id.button_blood_tests);
        emergency_notices = findViewById(R.id.button_emergency);
        blood_tests = findViewById(R.id.button7);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cus_View.this, Login.class);
                startActivity(intent);
            }
        });

        blood_banks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cus_View.this, View_Blood_Banks.class);
                startActivity(intent);
            }
        });

        emergency_notices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cus_View.this, View_Emergency_Notices_cus.class);
                startActivity(intent);
            }
        });
        blood_tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cus_View.this, View_Blood_Test_Cus.class);
                startActivity(intent);
            }
        });
    }
}