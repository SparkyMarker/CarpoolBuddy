package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class VehicleInfo extends AppCompatActivity implements vehicleViewHolder.OnNoteListener{
RecyclerView recVehicleView;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    protected Spinner filteringSpinner;
    private String selectedRole;

    //added for testing
    private ArrayList<Vehicle> vehiclesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);
        recVehicleView = findViewById(R.id.recVehicleView);


        recVehicleView.setLayoutManager(new LinearLayoutManager(this));

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        //added for testing
        vehiclesList = new ArrayList<Vehicle>();

        filteringSpinner = findViewById(R.id.spinner);
        setupSpinner();

    }


    public void setupSpinner() {
        String[] typesOfVehicles = {"Vehicle", "Helicopter", "Bycicle", "Segway", "Car"};
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(VehicleInfo.this,
                android.R.layout.simple_spinner_item, typesOfVehicles);
        langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filteringSpinner.setAdapter(langArrAdapter);

        filteringSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedRole = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void testDB(View v) {
        vehiclesList.clear();
        TaskCompletionSource<String> getAllRidesTask = new TaskCompletionSource<>();
        firestore.collection("Vehicles").whereEqualTo("open", true)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        vehiclesList.add(document.toObject(Vehicle.class));
                    }
                    getAllRidesTask.setResult(null);
                }
                else {
                    Log.d("VehiclesInfoActivity", "Error getting documents from db: ", task.getException());
                }
            }
        });
        // when all rides have been retrieved, update RecyclerView
        getAllRidesTask.getTask().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
               finished();
            }
        });
    }

        public void finished(){
            System.out.println("VEHICLE INFO: " + vehiclesList.toString());
            recViewAdapter myAdapter = new recViewAdapter(vehiclesList, this);

            recVehicleView.setAdapter(myAdapter);
        }

    public void selectedRoleAccessor(String selectedRole){
    this.selectedRole = selectedRole;
    }

    @Override
    public void onNoteClick(int position) {
        vehiclesList.get(position);
    Intent intent = new Intent(this, onClickPlace.class);
    intent.putExtra("vehiclesList", vehiclesList);
        startActivity(intent);
    }

    public void nextScreens(View v){
        Intent nextScreen = new Intent(this, Login.class);
        startActivity(nextScreen);
    }
}