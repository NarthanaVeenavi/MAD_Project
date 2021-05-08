package com.example.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class View_Blood_Test extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__blood__test);

        recyclerView = findViewById(R.id.recyclerView_three);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<BloodTestsModelClass> bloodTestsModelClasses = databaseHelperClass.getBloodTestsList();

        if(bloodTestsModelClasses.size() > 0){
            BloodTestsAdapterClass bloodTestsAdapterClass = new BloodTestsAdapterClass(bloodTestsModelClasses, View_Blood_Test.this);
            recyclerView.setAdapter(bloodTestsAdapterClass);

        }else{
            Toast.makeText(this, "There is no Blood Tests ", Toast.LENGTH_SHORT).show();        }
    }
}