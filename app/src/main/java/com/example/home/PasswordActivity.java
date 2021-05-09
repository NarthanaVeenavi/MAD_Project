package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {

    EditText username;
    Button reset;

    DatabaseHelperClass DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        username= (EditText) findViewById(R.id.username);
        reset = (Button) findViewById(R.id.reset);
        DB = new DatabaseHelperClass(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();

                Boolean checkusername = DB.checkusername(user);

                if(checkusername == true){

                    Intent intent = new Intent(getApplicationContext(), ResetActivity.class);
                    intent.putExtra("username", user);
                    startActivity(intent);

                }else
                {
                    Toast.makeText(PasswordActivity.this, "User does not exist",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}