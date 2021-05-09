package com.example.home;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DonorEnrollment extends AppCompatActivity {
    EditText editText_name, editText_address, editText_email, editText_password, editText_dob, editText_blood, editText_nic;
    Button button_save, button_view;
    DatabaseHelperClass databaseHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_enrollment);

        editText_name = findViewById(R.id.editText_name);
        editText_address = findViewById(R.id.editText_address);
        editText_email = findViewById(R.id.editText_email);
        editText_password = findViewById(R.id.editText_password);
        editText_dob = findViewById(R.id.editText_dob);
        editText_blood = findViewById(R.id.editText_blood);
        editText_nic = findViewById(R.id.editText_nic);


        button_view = findViewById(R.id.button_view);

        button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringAddress = editText_address.getText().toString();
                String stringEmail = editText_email.getText().toString();
                String stringPassword = editText_password.getText().toString();
                String stringDob = editText_dob.getText().toString();
                String stringBlood = editText_blood.getText().toString();
                String stringNic = editText_nic.getText().toString();
                if (stringName.length() <=0 || stringAddress.length() <=0  || stringEmail.length() <=0  || stringPassword.length() <=0  || stringDob.length() <=0 || stringBlood.length() <=0|| stringNic.length() <=0 ){
                    Toast.makeText(DonorEnrollment.this, "Enter Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass((DonorEnrollment.this));
                    DonorAccountModelClass donorAccountModelClass = new DonorAccountModelClass(stringName,stringAddress,stringEmail,stringPassword,stringDob,stringBlood,stringNic);
                    databaseHelperClass.addDonor(donorAccountModelClass);
                    Toast.makeText(DonorEnrollment.this, "Add Health Entry Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());

                }
            }

        });

        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonorEnrollment.this, ViewDonor.class);
                startActivity(intent);
            }
        });
    }
}
