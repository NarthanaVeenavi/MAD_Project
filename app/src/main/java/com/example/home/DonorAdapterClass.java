package com.example.home;

import android.app.Activity;
import android.content.ContentValues;
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

public class DonorAdapterClass extends RecyclerView.Adapter<DonorAdapterClass.ViewHolder>{

    List<DonorAccountModelClass> donor; //healthCard
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public DonorAdapterClass(List<DonorAccountModelClass> donor, Context context) {
        this.donor = donor;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.donor_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DonorAccountModelClass donorAccountModelClass = donor.get(position);

        holder.textViewID.setText(Integer.toString(donorAccountModelClass.getId()));
        holder.editText_name.setText(donorAccountModelClass.getdName());
        holder.editText_address.setText(donorAccountModelClass.getdAddress());
        holder.editText_dob.setText(donorAccountModelClass.getdDob());
        holder.editText_email.setText(donorAccountModelClass.getdEmail());
        holder.editText_blood.setText(donorAccountModelClass.getdBlood());
        holder.editText_nic.setText(donorAccountModelClass.getdNic());


    }


    @Override
    public int getItemCount() {
        return donor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_name;
        EditText editText_address;
        EditText editText_dob;
        EditText editText_email;
        EditText editText_blood;
        EditText editText_nic;
        Button button_edit;
        Button button_delete;
        public ViewHolder(@NonNull View itemView){

            super(itemView);

            textViewID = itemView.findViewById(R.id.textViewID);
            editText_name = itemView.findViewById(R.id.editText_name);
            editText_address = itemView.findViewById(R.id.editText_address);
            editText_dob = itemView.findViewById(R.id.editText_dob);
            editText_email = itemView.findViewById(R.id.editText_email);
            editText_blood = itemView.findViewById(R.id.editText_blood);
            editText_nic = itemView.findViewById(R.id.editText_nic);

            button_edit = itemView.findViewById(R.id.button_edit);
            button_delete = itemView.findViewById(R.id.button_delete);
        }
    }
}