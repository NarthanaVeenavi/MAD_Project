package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    TextView username;
    EditText password, confirmpassword;
    Button confirm;

    DatabaseHelperClass DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        username = (TextView) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        confirm = (Button) findViewById(R.id.confirm);
        DB = new DatabaseHelperClass(this);

        Intent intent = getIntent();
        username.setText(intent.getStringExtra("username"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.toString();
                String pass = password.toString();
                String newpass = confirmpassword.toString();

                    Boolean updateusernamepassword = DB.updateusernamepassword(user, pass);

                    if (updateusernamepassword == true) {

                        Intent intent = new Intent(getApplicationContext(), redwings_login.class);
                        startActivity(intent);
                        Toast.makeText(ResetActivity.this, "Password Updated", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ResetActivity.this, "Password not Updated", Toast.LENGTH_SHORT).show();
                    }


                }

            
        });
    }
}