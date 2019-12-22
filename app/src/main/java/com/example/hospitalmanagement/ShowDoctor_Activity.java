package com.example.hospitalmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagement.Model.PatientView;
import com.example.hospitalmanagement.ViewHolder.PatientViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowDoctor_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DatabaseReference UsersRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doctor_);

        UsersRef = FirebaseDatabase.getInstance().getReference().child("Users").child("doctors");

        recyclerView = findViewById(R.id.patient_recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        FirebaseRecyclerOptions<PatientView> options = new FirebaseRecyclerOptions.Builder<PatientView>().setQuery(UsersRef,PatientView.class).build();

        FirebaseRecyclerAdapter<PatientView, PatientViewHolder> adapter = new FirebaseRecyclerAdapter<PatientView, PatientViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull PatientViewHolder userViewHolder, int i, @NonNull final PatientView usersView)
            {
                userViewHolder.name.setText(usersView.getName());
                userViewHolder.address.setText(usersView.getAddress());
                userViewHolder.city.setText(usersView.getCity());
                userViewHolder.mobile.setText(usersView.getMobile());
            }

            @NonNull
            @Override
            public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_patient_layout,parent,false);
                PatientViewHolder holder = new PatientViewHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}