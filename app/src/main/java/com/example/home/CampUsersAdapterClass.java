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

public class CampUsersAdapterClass extends RecyclerView.Adapter<CampUsersAdapterClass.ViewHolder> {
    List<CampModelClass> camp;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public CampUsersAdapterClass(List<CampModelClass> camp, Context context) {
        this.camp = camp;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public CampUsersAdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.camp_user_item_list,parent,false);
        CampUsersAdapterClass.ViewHolder viewHolder = new CampUsersAdapterClass.ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull CampUsersAdapterClass.ViewHolder holder, int position) {
        final CampModelClass campModelClass = camp.get(position);

        holder.textViewID.setText(Integer.toString(campModelClass.getId()));
        holder.editText_Name.setText(campModelClass.getName());
        holder.editText_Phone.setText(campModelClass.getPhone());
        holder.editText_Date.setText(campModelClass.getDate());
        holder.editText_Time.setText(campModelClass.getTime());
        holder.editText_Venue.setText(campModelClass.getVenue());
        holder.editText_Description.setText(campModelClass.getDescription());


    }

    @Override
    public int getItemCount()
    {

        return camp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        TextView editText_Name;
        TextView editText_Phone;
        TextView editText_Date;
        TextView editText_Time;
        TextView editText_Venue;
        TextView editText_Description;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.editText_id);
            editText_Name = itemView.findViewById(R.id.editText_name);
            editText_Phone = itemView.findViewById(R.id.editText_phone);
            editText_Date = itemView.findViewById(R.id.editText_date);
            editText_Time = itemView.findViewById(R.id.editText_time);
            editText_Venue = itemView.findViewById(R.id.editText_venue);
            editText_Description = itemView.findViewById(R.id.editText_description);



        }
    }

}
