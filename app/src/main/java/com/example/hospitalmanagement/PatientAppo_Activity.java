package com.example.hospitalmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class PatientAppo_Activity extends AppCompatActivity {



    EditText Date,Time,Fee;
    Button Submit;
    String date,time,inputSpec;

    ArrayAdapter<String> arrayAdapter1;

    ProgressDialog loadingBar;


    DatabaseReference bookAppointmentref, DocAppoiRef;
    String mobno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_appo_);


        Date = (EditText) findViewById(R.id.date);
        Time = (EditText) findViewById(R.id.time);
        Fee = (EditText) findViewById(R.id.fee);
        Submit = (Button) findViewById(R.id.submit);
        loadingBar = new ProgressDialog(this);

        inputSpec = getIntent().getExtras().getString("spec");
        mobno = getIntent().getExtras().getString("mobno");


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });


    }

    private void validate()
    {
        date = Date.getText().toString();
        time = Time.getText().toString();

        if (TextUtils.isEmpty(date))
        {
            Toast.makeText(PatientAppo_Activity.this,"Please,Enter username.",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(time))
        {
            Toast.makeText(PatientAppo_Activity.this,"Please,Enter password.",Toast.LENGTH_SHORT).show();
        }
        else
        {

            loadingBar.setTitle("Loading ...");
            loadingBar.setMessage("Please wait...");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            storeDocDB();
        }
    }

    private void storeDocDB()
    {
        DocAppoiRef = FirebaseDatabase.getInstance().getReference().child("appointment").child(mobno);
        DocAppoiRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                HashMap<String, Object> appointmentDetails = new HashMap<>();

                appointmentDetails.put("mobile", mobno);
                appointmentDetails.put("spec",inputSpec);
                appointmentDetails.put("date",date);
                appointmentDetails.put("time", time);


                DocAppoiRef.updateChildren(appointmentDetails)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    loadingBar.dismiss();
                                    Toast.makeText(PatientAppo_Activity.this,"Congratulation,Appointment is Successfully created.",Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(PatientAppo_Activity.this,Patient_Activity.class);
                                    intent.putExtra("mobno",mobno);
                                    startActivity(intent);
                                }
                                else{
                                    loadingBar.dismiss();
                                    Toast.makeText(PatientAppo_Activity.this,"Network Error, Please try again after Sometime.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }


}
