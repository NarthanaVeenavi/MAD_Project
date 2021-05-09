package com.example.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewDonor extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_health_card);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<DonorAccountModelClass> donorAccountModelClasses = databaseHelperClass.getDonorList();

        if(donorAccountModelClasses.size()>0){
            DonorAdapterClass donorAdapterClass = new DonorAdapterClass(donorAccountModelClasses,ViewDonor.this);
            recyclerView.setAdapter(donorAdapterClass);
        }else{
            Toast.makeText(this,"there is no Health Entries", Toast.LENGTH_SHORT).show();

        }
    }
}