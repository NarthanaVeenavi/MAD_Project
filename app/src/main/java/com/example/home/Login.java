package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;
    Button signUp;
    DatabaseHelperClass myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.user_name_login);
        password = findViewById(R.id.password_login);
        btnLogin = findViewById(R.id.button8);
        signUp = findViewById(R.id.button_signup);

        myDB = new DatabaseHelperClass(Login.this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(Login.this, "Please enter the Credentials", Toast.LENGTH_SHORT).show();
                }
                else{

                    Boolean result = myDB.checkUsernamePassword(user, pass);
                    if(result == true){
                        Intent intent = new Intent(Login.this, Dashboard.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Add_Blood_Banks.class);
                startActivity(intent);
            }
        });

    }
}