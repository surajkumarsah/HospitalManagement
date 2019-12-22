package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Patient_Activity extends AppCompatActivity {


    Spinner Specialization;


    Button Submit;
    String date,time,inputSpec,mobno;

    ArrayAdapter<String> arrayAdapter1;

    String specializations[] = {"Gynecologist","Physician","Dermatologist","Homeopath","Ayurveda","Dentist","E-n-t Specialist","Bones Specialist"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_);

        Specialization = (Spinner) findViewById(R.id.specialization);
        Submit = (Button) findViewById(R.id.submit);

        mobno = getIntent().getExtras().getString("mobno");


        //Specialization Spinner Code for drop down
        arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,specializations);

        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Specialization.setAdapter(arrayAdapter1);

        Specialization.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0:
                        inputSpec = "Gynecologist";
                        break;

                    case 1:
                        inputSpec = "Physician";
                        break;
                    case 2:
                        inputSpec = "Dermatologist";
                        break;

                    case 3:
                        inputSpec = "Homeopath";
                        break;
                    case 4:
                        inputSpec = "Ayurveda";
                        break;

                    case 5:
                        inputSpec = "Dentist";
                        break;
                    case 6:
                        inputSpec = "E-n-t Specialist";
                        break;

                    case 7:
                        inputSpec = "Bones Specialist";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Patient_Activity.this,PatientAppo_Activity.class);
                intent.putExtra("spec",inputSpec);
                intent.putExtra("mobno",mobno);
                startActivity(intent);
            }
        });




    }

}
