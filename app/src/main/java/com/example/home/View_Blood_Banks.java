package com.example.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class View_Blood_Banks extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__blood__banks);

        recyclerView = findViewById(R.id.recyclerView_two);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<BloodBankDetailsModelClass> bloodBankDetailsModelClasses = databaseHelperClass.getBloodBanksList();

        if(bloodBankDetailsModelClasses.size() > 0){
            BloodBanksAdapterClass bloodBanksAdapterClass = new BloodBanksAdapterClass(bloodBankDetailsModelClasses, View_Blood_Banks.this);
            recyclerView.setAdapter(bloodBanksAdapterClass);

        }else{
            Toast.makeText(this, "There is no Blood Banks ", Toast.LENGTH_SHORT).show();        }
    }
}