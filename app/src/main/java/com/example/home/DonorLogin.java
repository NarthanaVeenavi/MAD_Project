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

import java.io.Serializable;

public class DonorLogin extends AppCompatActivity {
    private EditText editText_nic, editText_password;
    private Button button_login, button_signup;

    DatabaseHelperClass databaseHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_login);

        editText_nic = findViewById(R.id.editText_nic);
        editText_password = findViewById(R.id.editText_password);

        databaseHelperClass = new DatabaseHelperClass(this);

        button_login = (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  String nic = editText_nic.getText().toString();
                String pass = editText_password.getText().toString();

                if(nic.equals("") || pass.equals("")){
                    Toast.makeText(DonorLogin.this,"Please Enter Credentials",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean result = databaseHelperClass.checkNicPassword(nic,pass);
                    if(result==true){
                        Intent intent = new Intent(getApplicationContext(), DonorHome.class);
                        startActivity(intent);
                    }else
                        {
                        Toast.makeText(DonorLogin.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }*/
            }
        });

        button_signup = (Button) findViewById(R.id.button_signup);
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DonorHome.class);
                startActivity(intent);
            }
        });


    }


}

