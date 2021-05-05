package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Emergency_Notice extends AppCompatActivity {

    EditText editText_hosName, editText_phoneNum, editText_description;
    Button button_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__emergency__notice);

        editText_hosName = findViewById(R.id.editTextTextPersonName2);
        editText_phoneNum = findViewById(R.id.editTextTextPersonName3);
        editText_description = findViewById(R.id.editTextTextMultiLine);
        button_add = findViewById(R.id.button2);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringHosName = editText_hosName.getText().toString();
                String stringPhoneNum = editText_phoneNum.getText().toString();
                String stringDescription = editText_description.getText().toString();

                if(stringHosName.length() <= 0 || stringPhoneNum.length() <= 0 || stringDescription.length() <= 0){
                    Toast.makeText(Add_Emergency_Notice.this, "Enter all Data", Toast.LENGTH_SHORT).show();
                }else{
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Add_Emergency_Notice.this);
                    EmergencyNoticesModelClass emergencyNoticesModelClass = new EmergencyNoticesModelClass(stringHosName, stringPhoneNum, stringDescription);
                    databaseHelperClass.addEmergencyNotice(emergencyNoticesModelClass);
                    Toast.makeText(Add_Emergency_Notice.this, "Added Emergency Notice Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent= new Intent(Add_Emergency_Notice.this,View_Emergency_Notices.class);
                    startActivity(intent);
                }
            }
        });

    }
}