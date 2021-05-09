package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newReq extends AppCompatActivity {

    EditText edtBld, edtTyp, edtName, edtPhne, edtDet;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_req);

        edtBld = findViewById(R.id.edtBldgrp);
        edtTyp = findViewById(R.id.edtReqTyp);
        edtName = findViewById(R.id.edtName);
        edtPhne = findViewById(R.id.edtPhne);
        edtDet = findViewById(R.id.edtDet);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringBld = edtBld.getText().toString();
                String stringTyp = edtTyp.getText().toString();
                String stringName = edtName.getText().toString();
                String stringPhne = edtPhne.getText().toString();
                String stringDet = edtDet.getText().toString();

                if(stringBld.length() <= 0 || stringTyp.length() <= 0 || stringPhne.length() <= 0){
                    Toast.makeText(newReq.this, "Enter Reqired Data!", Toast.LENGTH_LONG).show();
                }else{
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(newReq.this);
                    RequestModelClass requestModelClass = new RequestModelClass(stringBld,stringTyp,stringName,stringPhne,stringDet);
                    databaseHelperClass.addRequest(requestModelClass);
                    Toast.makeText(newReq.this, "Request Created!", Toast.LENGTH_LONG).show();

                    finish();
                    startActivity(getIntent());
                }
            }
        });
    }
}