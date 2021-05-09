package com.example.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class BloodBanksAdapterClass extends RecyclerView.Adapter<BloodBanksAdapterClass.ViewHolder>{


        List<BloodBankDetailsModelClass> bloodBanks;
        Context context;
        DatabaseHelperClass databaseHelperClass;

        public BloodBanksAdapterClass(List<BloodBankDetailsModelClass> bloodBanks, Context context) {
            this.bloodBanks = bloodBanks;
            this.context = context;
            databaseHelperClass = new DatabaseHelperClass(context);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.blood_banks_list,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final BloodBankDetailsModelClass bloodBankDetailsModelClass = bloodBanks.get(position);

            holder.text_name.setText(bloodBankDetailsModelClass.getBloodBankName());
            holder.text_address.setText(bloodBankDetailsModelClass.getAddress());
            holder.text_phone.setText(bloodBankDetailsModelClass.getPhone_number());
            //holder.text_district.setText(bloodBankDetailsModelClass.getDistrict());
            holder.text_city.setText(bloodBankDetailsModelClass.getCity());
            //holder.text_postal_code.setText(bloodBankDetailsModelClass.getPostalCode());


        }

        @Override
        public int getItemCount() {
            return bloodBanks.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView text_name;
            TextView text_address;
            TextView text_phone;
            //TextView text_district;
            TextView text_city;
            //TextView text_postal_code;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                text_name = itemView.findViewById(R.id.text_name);
                text_address = itemView.findViewById(R.id.text_address);
                text_phone = itemView.findViewById(R.id.text_phone);
                //text_district = itemView.findViewById(R.id.text_district);
                text_city = itemView.findViewById(R.id.text_city);
                //text_postal_code = itemView.findViewById(R.id.text_postal_code);


            }
        }



    }


