package com.example.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class reqPage extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_page);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<RequestModelClass> requestModelClasses = databaseHelperClass.getRequestList();

        if(requestModelClasses.size() > 0){
            RequestAdapterClass requestAdapterClass = new RequestAdapterClass(requestModelClasses, reqPage.this);
            recyclerView.setAdapter(requestAdapterClass);
        }else{
            Toast.makeText(this, "There are no requests yet!", Toast.LENGTH_SHORT).show();
        }
    }
}