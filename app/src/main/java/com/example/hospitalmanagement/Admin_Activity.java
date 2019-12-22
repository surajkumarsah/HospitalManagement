package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Admin_Activity extends AppCompatActivity {


    ImageView Patient,Doctor,Appointment,ShowPatient,ShowDoctor;
    String mobno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_);

        Patient = (ImageView) findViewById(R.id.patient);
        Doctor = (ImageView) findViewById(R.id.doctor);
        //Appointment = (ImageView) findViewById(R.id.appointment);
        ShowPatient = (ImageView) findViewById(R.id.showpatient);
        ShowDoctor = (ImageView) findViewById(R.id.showdoctor);


        mobno = getIntent().getExtras().getString("mobno");

        Patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Activity.this,SignUp_Activity.class);
                startActivity(intent);
            }
        });

        ShowPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Activity.this,ShowPatient_Activity.class);
                startActivity(intent);
            }
        });

        Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Activity.this,AddDoctors_Activity.class);
                startActivity(intent);
            }
        });


        ShowDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Activity.this,ShowDoctor_Activity.class);
                startActivity(intent);
            }
        });

        /*Appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Activity.this,Appointment_Activity.class);
                startActivity(intent);
            }
        });*/
    }
}
