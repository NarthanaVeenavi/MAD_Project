package com.example.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class viewOrganizationDetails extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_organization_details);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<OrganizationModelClass> organizationModelClasses = databaseHelperClass.getOrganizationList();

        if (organizationModelClasses.size() > 0){
            OrganizationAdapterClass organizationAdapterClass = new OrganizationAdapterClass(organizationModelClasses, viewOrganizationDetails.this);
            recyclerView.setAdapter(organizationAdapterClass);
        }else {
            Toast.makeText(this, "There is no camp data in the database", Toast.LENGTH_SHORT).show();
        }


    }
}