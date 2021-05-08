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

public class Em_NoticesCusAdapterClass extends RecyclerView.Adapter<Em_NoticesCusAdapterClass.ViewHolder>{

    List<EmergencyNoticesModelClass> emergencyNotices;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public Em_NoticesCusAdapterClass(List<EmergencyNoticesModelClass> emergencyNotices, Context context) {
        this.emergencyNotices = emergencyNotices;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.emergency_notices_cus_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EmergencyNoticesModelClass emergencyNoticesModelClass = emergencyNotices.get(position);

        holder.editText_Hosname.setText(emergencyNoticesModelClass.getHos_name());
        holder.editText_phone.setText(emergencyNoticesModelClass.getPhone_num());
        holder.editText_description.setText(emergencyNoticesModelClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return emergencyNotices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView editText_Hosname;
        TextView editText_phone;
        TextView editText_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            editText_Hosname = itemView.findViewById(R.id.edittext_Hosname);
            editText_phone = itemView.findViewById(R.id.edittext_phone);
            editText_description = itemView.findViewById(R.id.edittext_description);
        }
    }


}
