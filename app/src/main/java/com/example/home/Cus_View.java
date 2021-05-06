package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cus_View extends AppCompatActivity {

    Button skip, blood_banks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus__view);

        skip = findViewById(R.id.button);
        blood_banks = findViewById(R.id.button_blood_banks);

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
    }
}