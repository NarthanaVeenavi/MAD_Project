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

public class BloodTestsAdapterClass extends RecyclerView.Adapter<BloodTestsAdapterClass.ViewHolder>{

    List<BloodTestsModelClass> bloodTests;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public BloodTestsAdapterClass(List<BloodTestsModelClass> bloodTests, Context context) {
        this.bloodTests = bloodTests;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.blood_tests_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final BloodTestsModelClass bloodTestsModelClass = bloodTests.get(position);

        holder.text_id.setText(Integer.toString(bloodTestsModelClass.getId()));
        holder.editText_HosName.setText(bloodTestsModelClass.getHos_name());
        holder.editText_date.setText(bloodTestsModelClass.getDate());
        holder.editText_time.setText(bloodTestsModelClass.getTime());
        holder.editText_phone.setText(bloodTestsModelClass.getPhone());
        holder.editText_tests.setText(bloodTestsModelClass.getBlood_tests());

        //on adapter class when click edit button then call updateEmergencyNotices method

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringHosName = holder.editText_HosName.getText().toString();
                String stringDate = holder.editText_date.getText().toString();
                String stringTime = holder.editText_time.getText().toString();
                String stringPhone = holder.editText_phone.getText().toString();
                String stringTests = holder.editText_tests.getText().toString();

                databaseHelperClass.updateBloodTests(new BloodTestsModelClass(bloodTestsModelClass.getId(), stringHosName, stringDate, stringTime, stringPhone, stringTests));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());

            }
        });

        //When click delete button then call to deleteEmergencyNotices method
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseHelperClass.deleteBloodTests(bloodTestsModelClass.getId());
                bloodTests.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bloodTests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_id;
        EditText editText_HosName;
        EditText editText_date;
        EditText editText_time;
        EditText editText_phone;
        EditText editText_tests;
        Button button_delete;
        Button button_Edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text_id = itemView.findViewById(R.id.text_id);
            editText_HosName = itemView.findViewById(R.id.editText_HosName);
            editText_date = itemView.findViewById(R.id.editText_date);
            editText_time = itemView.findViewById(R.id.editText_time);
            editText_phone = itemView.findViewById(R.id.editText_phone);
            editText_tests = itemView.findViewById(R.id.editText_tests);
            button_Edit = itemView.findViewById(R.id.button_edit);
            button_delete = itemView.findViewById(R.id.button_delete);
        }
    }

}
