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


public class CampAdapterClass extends  RecyclerView.Adapter<CampAdapterClass.ViewHolder>{

        List<CampModelClass> camp;
        Context context;
        DatabaseHelperClass databaseHelperClass;

        public CampAdapterClass(List<CampModelClass> camp, Context context) {
            this.camp = camp;
            this.context = context;
            databaseHelperClass = new DatabaseHelperClass(context);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.camp_item_list,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final CampModelClass campModelClass = camp.get(position);

            holder.textViewID.setText(Integer.toString(campModelClass.getId()));
            holder.editText_Name.setText(campModelClass.getName());
            holder.editText_Phone.setText(campModelClass.getPhone());
            holder.editText_Date.setText(campModelClass.getDate());
            holder.editText_Time.setText(campModelClass.getTime());
            holder.editText_Venue.setText(campModelClass.getVenue());
            holder.editText_Description.setText(campModelClass.getDescription());

            holder.button_Edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String stringName = holder.editText_Name.getText().toString();
                    String stringPhone = holder.editText_Phone.getText().toString();
                    String stringDate = holder.editText_Date.getText().toString();
                    String stringTime = holder.editText_Time.getText().toString();
                    String stringVenue = holder.editText_Venue.getText().toString();
                    String stringDescription = holder.editText_Description.getText().toString();

                    databaseHelperClass.updateCamp(new CampModelClass(campModelClass.getId(),stringName,
                            stringPhone,stringDate,stringTime,stringVenue,stringDescription));
                    notifyDataSetChanged();
                    ((Activity) context).finish();
                    context.startActivity(((Activity) context).getIntent());
                }
            });

            holder.button_Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    databaseHelperClass.deleteCamp(campModelClass.getId());
                    camp.remove(position);
                    notifyDataSetChanged();

                }
            });

        }

        @Override
        public int getItemCount()
        {

            return camp.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView textViewID;
            EditText editText_Name;
            EditText editText_Phone;
            EditText editText_Date;
            EditText editText_Time;
            EditText editText_Venue;
            EditText editText_Description;
            Button button_Edit;
            Button button_Delete;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                textViewID = itemView.findViewById(R.id.editText_id);
                editText_Name = itemView.findViewById(R.id.editText_name);
                editText_Phone = itemView.findViewById(R.id.editText_phone);
                editText_Date = itemView.findViewById(R.id.editText_date);
                editText_Time = itemView.findViewById(R.id.editText_time);
                editText_Venue = itemView.findViewById(R.id.editText_venue);
                editText_Description = itemView.findViewById(R.id.editText_description);
                button_Edit = itemView.findViewById(R.id.button_edit);
                button_Delete = itemView.findViewById(R.id.button_delete);


            }
        }

    }
