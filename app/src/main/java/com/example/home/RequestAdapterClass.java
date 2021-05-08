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

public class RequestAdapterClass extends RecyclerView.Adapter<RequestAdapterClass.ViewHolder> {

    List<RequestModelClass> request;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public RequestAdapterClass(List<RequestModelClass> request, Context context) {
        this.request = request;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.request_item_list,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RequestModelClass requestModelClass = request.get(position);
        holder.edtBldgrp.setText(requestModelClass.getBld());
        holder.edtReqTyp.setText(requestModelClass.getTyp());
        holder.edtName.setText(requestModelClass.getName());
        holder.edtPhne.setText(requestModelClass.getPhne());
        holder.edtDet.setText(requestModelClass.getDet());

        holder.btnEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringBldgrp = holder.edtBldgrp.getText().toString();
                String stringReqtype = holder.edtReqTyp.getText().toString();
                String stringName = holder.edtName.getText().toString();
                String stringPhne = holder.edtPhne.getText().toString();
                String stringDet = holder.edtDet.getText().toString();

                databaseHelperClass.updateRequest(new RequestModelClass(requestModelClass.getId(), stringBldgrp, stringReqtype, stringName, stringPhne,stringDet));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });
        holder.btnDlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteRequest(requestModelClass.getId());
                request.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return request.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        EditText edtBldgrp, edtReqTyp, edtName, edtPhne, edtDet;
        Button btnEdt, btnDlt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            edtBldgrp = itemView.findViewById(R.id.edtBldGr);
            edtReqTyp = itemView.findViewById(R.id.edtReqT);
            edtName = itemView.findViewById(R.id.edtNm);
            edtPhne = itemView.findViewById(R.id.edtPhn);
            edtDet = itemView.findViewById(R.id.edtDt);
            btnEdt =itemView.findViewById(R.id.btnEdt);
            btnDlt =itemView.findViewById(R.id.btnDlt);
        }
    }
}
