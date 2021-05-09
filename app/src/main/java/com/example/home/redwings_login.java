package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class redwings_login extends AppCompatActivity {

    public Button button1;
    public Button button3;
    public Button button2;

    EditText username,password;
    DatabaseHelperClass myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redwings_login);

        username = (EditText) findViewById(R.id.editText_username);
        password = (EditText) findViewById(R.id.editText_password);


       button1 = (Button) findViewById(R.id.button1);

       myDB = new DatabaseHelperClass(this);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(redwings_login.this,"please enter Credentials.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean result = myDB.checkusernamepassword(user,pass);

                    if(result == true){

                        Intent intent = new Intent(redwings_login.this,   organizaion_page.class );
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(redwings_login.this,"please enter valid details", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });



        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(redwings_login.this, reg_org.class );
                startActivity(intent3);
            }
        });

        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(redwings_login.this, PasswordActivity.class);
                startActivity(intent2);
            }
        });
    }
}