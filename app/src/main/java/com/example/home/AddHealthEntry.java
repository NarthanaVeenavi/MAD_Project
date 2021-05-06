package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddHealthEntry extends AppCompatActivity {

    EditText editText_date, editText_venue, editText_health, editText_title, editText_description;
    Button button_save,button_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_entry);

        editText_date = findViewById(R.id.editText_date);
        editText_venue = findViewById(R.id.editText_venue);
        editText_health = findViewById(R.id.editText_health);
        editText_title = findViewById(R.id.editText_title);
        editText_description = findViewById(R.id.editText_description);

        button_save = findViewById(R.id.button_save);
        button_view = findViewById(R.id.button_view);


        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringDate = editText_date.getText().toString();
                String stringVenue = editText_venue.getText().toString();
                String stringHealth = editText_health.getText().toString();
                String stringTitle = editText_title.getText().toString();
                String stringDes = editText_description.getText().toString();

                if (stringDate.length() <=0 || stringVenue.length() <=0  || stringHealth.length() <=0  || stringTitle.length() <=0  || stringDes.length() <=0  ){
                    Toast.makeText(AddHealthEntry.this, "Enter Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass((AddHealthEntry.this));
                    HealthCardModelClass healthCardModelClass = new HealthCardModelClass(stringDate,stringVenue,stringHealth,stringTitle,stringDes);
                    databaseHelperClass.addHealthCard(healthCardModelClass);
                    Toast.makeText(AddHealthEntry.this, "Add Health Entry Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());

                }
            }
        });

        button_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(AddHealthEntry.this, ViewHealthCard.class);
                startActivity(intent);
            }
        });
    }


    }
