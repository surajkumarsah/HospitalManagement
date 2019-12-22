package com.example.hospitalmanagement.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagement.Interface.PatientClickListner;
import com.example.hospitalmanagement.R;

public class PatientViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{


public TextView name,address,city,email,mobile;
public PatientClickListner listner;

public PatientViewHolder(@NonNull View itemView)
        {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name);
        address = (TextView) itemView.findViewById(R.id.address);
        city = (TextView) itemView.findViewById(R.id.city);
        email = (TextView) itemView.findViewById(R.id.email);
        mobile = (TextView) itemView.findViewById(R.id.mobile);
        }

public void setPatientClickListener(PatientClickListner listner)
        {
        this.listner = listner;
        }

@Override
public void onClick(View v) {
        listner.onClick(v,getAdapterPosition(),false);
        }
}