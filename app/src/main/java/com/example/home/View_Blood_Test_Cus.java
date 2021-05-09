package com.example.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class View_Blood_Test_Cus extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__blood__test__cus);

        recyclerView = findViewById(R.id.recyclerView_three);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<BloodTestsModelClass> bloodTestsModelClasses = databaseHelperClass.getBloodTestsList();

        if(bloodTestsModelClasses.size() > 0){
            BloodTest_Cus_AdapterClass bloodTest_cus_adapterClass = new BloodTest_Cus_AdapterClass(bloodTestsModelClasses, View_Blood_Test_Cus.this);
            recyclerView.setAdapter(bloodTest_cus_adapterClass);

        }else{
            Toast.makeText(this, "There is no Blood Tests ", Toast.LENGTH_SHORT).show();        }
    }
}