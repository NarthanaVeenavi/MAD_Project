package com.example.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class viewCampDetailsUsers extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_camp_details_users);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<CampModelClass> campModelClasses = databaseHelperClass.getCampList();

        if (campModelClasses.size() > 0){
            CampUsersAdapterClass campUsersAdapterClass = new CampUsersAdapterClass(campModelClasses, viewCampDetailsUsers.this);
            recyclerView.setAdapter(campUsersAdapterClass);
        }else {
            Toast.makeText(this, "There is no camp data in the database", Toast.LENGTH_SHORT).show();
        }
    }
}