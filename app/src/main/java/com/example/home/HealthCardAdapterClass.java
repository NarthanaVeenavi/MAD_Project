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

public class HealthCardAdapterClass extends RecyclerView.Adapter<HealthCardAdapterClass.ViewHolder>{

    List<HealthCardModelClass> healthCard;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public HealthCardAdapterClass(List<HealthCardModelClass> healthCard, Context context) {
        this.healthCard = healthCard;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.health_card_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final HealthCardModelClass healthCardModelClass = healthCard.get(position);

        holder.textViewID.setText(Integer.toString(healthCardModelClass.getId()));
        holder.editText_date.setText(healthCardModelClass.getDate());
        holder.editText_venue.setText(healthCardModelClass.getVenue());
        holder.editText_health.setText(healthCardModelClass.getHealth());
        holder.editText_title.setText(healthCardModelClass.getTitle());
        holder.editText_description.setText(healthCardModelClass.getDescription());

        holder.button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer intId = healthCardModelClass.getId();
                String stringDate = holder.editText_date.getText().toString();
                String stringVenue = holder.editText_venue.getText().toString();
                String stringTitle = holder.editText_title.getText().toString();
                String stringDescription = holder.editText_description.getText().toString();

                databaseHelperClass.updateHealthCard(new HealthCardModelClass(intId,stringDate,stringVenue,stringTitle,stringDescription));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteHealthCard(healthCardModelClass.getId());
                healthCard.remove(position);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return healthCard.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_date;
        EditText editText_venue;
        EditText editText_health;
        EditText editText_title;
        EditText editText_description;
        Button button_edit;
        Button button_delete;
        public ViewHolder(@NonNull View itemView){

            super(itemView);

            textViewID = itemView.findViewById(R.id.textViewID);
            editText_date = itemView.findViewById(R.id.editText_date);
            editText_venue = itemView.findViewById(R.id.editText_venue);
            editText_health = itemView.findViewById(R.id.editText_health);
            editText_title = itemView.findViewById(R.id.editText_title);
            editText_description = itemView.findViewById(R.id.editText_description);

            button_edit = itemView.findViewById(R.id.button_edit);
            button_delete = itemView.findViewById(R.id.button_delete);
        }
    }
}
