package com.example.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BloodTest_Cus_AdapterClass extends RecyclerView.Adapter<BloodTest_Cus_AdapterClass.ViewHolder>{

    List<BloodTestsModelClass> bloodTests;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public BloodTest_Cus_AdapterClass(List<BloodTestsModelClass> bloodTests, Context context) {
        this.bloodTests = bloodTests;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.blood_tests_cus_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final BloodTestsModelClass bloodTestsModelClass = bloodTests.get(position);

        holder.editText_HosName.setText(bloodTestsModelClass.getHos_name());
        holder.editText_date.setText(bloodTestsModelClass.getDate());
        holder.editText_time.setText(bloodTestsModelClass.getTime());
        holder.editText_phone.setText(bloodTestsModelClass.getPhone());
        holder.editText_tests.setText(bloodTestsModelClass.getBlood_tests());

        //on adapter class when click edit button then call updateEmergencyNotices method


    }

    @Override
    public int getItemCount() {
        return bloodTests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView editText_HosName;
        TextView editText_date;
        TextView editText_time;
        TextView editText_phone;
        TextView editText_tests;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            editText_HosName = itemView.findViewById(R.id.editText_HosName);
            editText_date = itemView.findViewById(R.id.editText_date);
            editText_time = itemView.findViewById(R.id.editText_time);
            editText_phone = itemView.findViewById(R.id.editText_phone);
            editText_tests = itemView.findViewById(R.id.editText_tests);

        }
    }

}
