/*
package com.example.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class View_Emergency_Notices extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__emergency__notices);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<EmergencyNoticesModelClass> emergencyNoticesModelClasses = databaseHelperClass.getEmergencyNoticesList();

        if(emergencyNoticesModelClasses.size() > 0){
            EmergencyNoticesAdapterClass emergencyNoticesAdapterClass = new EmergencyNoticesAdapterClass(emergencyNoticesModelClasses, View_Emergency_Notices.this);
            recyclerView.setAdapter(emergencyNoticesAdapterClass);

        }else{
            Toast.makeText(this, "There is no emergency Notices ", Toast.LENGTH_SHORT).show();        }
    }
}*/
