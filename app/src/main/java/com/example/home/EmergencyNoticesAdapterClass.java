/*
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

public class EmergencyNoticesAdapterClass extends RecyclerView.Adapter<EmergencyNoticesAdapterClass.ViewHolder>{


    List<EmergencyNoticesModelClass> emergencyNotices;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public EmergencyNoticesAdapterClass(List<EmergencyNoticesModelClass> emergencyNotices, Context context) {
        this.emergencyNotices = emergencyNotices;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.emergency_notices_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EmergencyNoticesModelClass emergencyNoticesModelClass = emergencyNotices.get(position);

        holder.textViewID.setText(Integer.toString(emergencyNoticesModelClass.getId()));
        holder.editText_Hosname.setText(emergencyNoticesModelClass.getHos_name());
        holder.editText_phone.setText(emergencyNoticesModelClass.getPhone_num());
        holder.editText_description.setText(emergencyNoticesModelClass.getDescription());

        //on adapter class when click edit button then call updateEmergencyNotices method

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringHosName = holder.editText_Hosname.getText().toString();
                String stringPhone = holder.editText_phone.getText().toString();
                String stringDescription = holder.editText_description.getText().toString();

                databaseHelperClass.updateEmergencyNotices(new EmergencyNoticesModelClass(emergencyNoticesModelClass.getId(), stringHosName, stringPhone, stringDescription));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());

            }
        });

        //When click delete button then call to deleteEmergencyNotices method
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseHelperClass.deleteEmergencyNotices(emergencyNoticesModelClass.getId());
                emergencyNotices.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return emergencyNotices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewID;
        EditText editText_Hosname;
        EditText editText_phone;
        EditText editText_description;
        Button button_delete;
        Button button_Edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Hosname = itemView.findViewById(R.id.edittext_Hosname);
            editText_phone = itemView.findViewById(R.id.edittext_phone);
            editText_description = itemView.findViewById(R.id.edittext_description);
            button_Edit = itemView.findViewById(R.id.button_edit);
            button_delete = itemView.findViewById(R.id.button_delete);
        }
    }



}

*/
