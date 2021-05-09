package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Camp extends AppCompatActivity {

    public Button button1;

    public EditText editText_orgname, editText_phone, editText_date, editText_time, editText_venue, editText_description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_camp);


        editText_orgname = findViewById(R.id.editText_orgname);
        editText_phone = findViewById(R.id.editText_phone);
        editText_date = findViewById(R.id.editText_date);
        editText_time = findViewById(R.id.editText_time);
        editText_venue = findViewById(R.id.editText_venue);
        editText_description = findViewById(R.id.editText_description);


        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringName = editText_orgname.getText().toString();
                String stringPhone = editText_phone.getText().toString();
                String stringDate = editText_date.getText().toString();
                String stringTime = editText_time.getText().toString();
                String stringVenue = editText_venue.getText().toString();
                String stringDescription = editText_description.getText().toString();

                if(stringName.length() <= 0 || stringPhone.length() <= 0 || stringDate.length() <= 0 ||
                        stringTime.length() <= 0 || stringVenue.length() <= 0 ||stringDescription.length() <= 0 )
                {
                    Toast.makeText(Add_Camp.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }
                else if(stringPhone.length() != 10){
                    Toast.makeText(Add_Camp.this, "Phone Number should have only 10 numbers", Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Add_Camp.this);
                    CampModelClass campModelClass = new CampModelClass( stringName, stringPhone, stringDate, stringTime, stringVenue, stringDescription);
                    databaseHelperClass.addCamp(campModelClass);
                    Toast.makeText(Add_Camp.this, "Add Camp Details Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(Add_Camp.this, organizaion_page.class);
                    startActivity(intent);
                }

            }
        });

    }
}