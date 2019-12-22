package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonpatient, Doctorlogin, Adminlogin, PatientSignup;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonpatient = (Button) findViewById(R.id.patient);
        Doctorlogin = (Button) findViewById(R.id.doctor);
        Adminlogin = (Button) findViewById(R.id.admin);
        PatientSignup = (Button) findViewById(R.id.signup);



        buttonpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                data = "patient";
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });

        Doctorlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                data = "doctor";
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });

        Adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                data = "admin";
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });

        PatientSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, SignUp_Activity.class);
                data = "admin";
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });

    }
}
