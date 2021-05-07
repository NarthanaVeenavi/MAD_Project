package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Blood_Test extends AppCompatActivity {

    EditText editTextHosName, editTextDate, editTextTime, editTextPhone, BloodTests;
    Button button_blood_tests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__blood__test);

        editTextHosName = findViewById(R.id.editTextHosName);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextPhone = findViewById(R.id.editTextPhone);
        BloodTests = findViewById(R.id.BloodTests);
        button_blood_tests = findViewById(R.id.button_blood_tests);

        button_blood_tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strHosName = editTextHosName.getText().toString();
                String strDate = editTextDate.getText().toString();
                String strTime = editTextTime.getText().toString();
                String strPhone = editTextPhone.getText().toString();
                String strBloodTests = BloodTests.getText().toString();

                if(strHosName.length() <= 0 || strDate.length() <= 0 || strTime.length() <= 0 || strPhone.length() <= 0 || strBloodTests.length() <= 0){
                    Toast.makeText(Add_Blood_Test.this, "Enter all data", Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Add_Blood_Test.this);
                    BloodTestsModelClass bloodTestsModelClass = new BloodTestsModelClass(strHosName, strDate, strTime, strPhone, strBloodTests);
                    databaseHelperClass.addBloodTests(bloodTestsModelClass);
                    Toast.makeText(Add_Blood_Test.this, "Added Blood Test Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(Add_Blood_Test.this,View_Blood_Test.class);
                    startActivity(intent);
                }
            }
        });
    }
}