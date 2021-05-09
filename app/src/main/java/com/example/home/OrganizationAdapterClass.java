package com.example.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrganizationAdapterClass extends RecyclerView.Adapter<OrganizationAdapterClass.ViewHolder> {

    List<OrganizationModelClass> organization;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public OrganizationAdapterClass(List<OrganizationModelClass> organization, Context context) {
        this.organization = organization;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.organization_item_list,parent,false);
        OrganizationAdapterClass.ViewHolder viewHolder = new  OrganizationAdapterClass.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final OrganizationModelClass organizationModelClass = organization.get(position);

        holder.textViewID1.setText(Integer.toString(organizationModelClass.getId1()));
        holder.editText_Orgame.setText(organizationModelClass.getOrgname());
        holder.editText_Address.setText(organizationModelClass.getAddress());
        holder.editText_Phonenumber.setText(organizationModelClass.getPhonenumber());
        holder.editText_District.setText(organizationModelClass.getDistrict());
        holder.editText_City.setText(organizationModelClass.getCity());
        holder.editText_Pastalcode.setText(organizationModelClass.getPostalcode());
        /*holder.editText_Username.setText(organizationModelClass.getUsername());
        holder.editText_Password.setText(organizationModelClass.getPassword());*/


    }

    @Override
    public int getItemCount() {

        return organization.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewID1;
        TextView editText_Orgame;
        TextView editText_Address;
        TextView editText_Phonenumber;
        TextView editText_District;
        TextView editText_City;
        TextView editText_Pastalcode;
        /*TextView editText_Username;
        TextView editText_Password;*/

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID1 = itemView.findViewById(R.id.editText_id1);
            editText_Orgame = itemView.findViewById(R.id.org_name1);
            editText_Address = itemView.findViewById(R.id.org_address2);
            editText_Phonenumber = itemView.findViewById(R.id.org_phonenumber3);
            editText_District = itemView.findViewById(R.id.org_district4);
            editText_City = itemView.findViewById(R.id.org_city5);
            editText_Pastalcode = itemView.findViewById(R.id.org_postalcode6);
            /*editText_Username = itemView.findViewById(R.id.org_username7);
            editText_Password = itemView.findViewById(R.id.org_password8);*/
        }
    }
}
