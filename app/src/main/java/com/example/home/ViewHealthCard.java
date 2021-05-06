package com.example.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewHealthCard extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_health_card);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<HealthCardModelClass> healthCardModelClasses =databaseHelperClass.getHealthCardList();

        if(healthCardModelClasses.size()>0){
            HealthCardAdapterClass healthCardAdapterClass = new HealthCardAdapterClass(healthCardModelClasses,ViewHealthCard.this);
            recyclerView.setAdapter(healthCardAdapterClass);
        }else{
            Toast.makeText(this,"there is no Health Entries", Toast.LENGTH_SHORT).show();

        }
    }
}