package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.example.carpoolbuddy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class onClickPlace extends AppCompatActivity {

    private FirebaseFirestore fireStore;
    private FirebaseAuth mAuth;
    private TextView owner, model, capacity, vehicleType, basePrice;
    private LinearLayout viewLayout;
    private String selectedRole, ownerText, modelText, vehicleTypeText;
    private int capacityAmount;
    private double basePriceAmount;
    private int position;
    private ArrayList<Vehicle> vehicleArrayList;
    //private ArrayList<String> addReservedUid;
    private Button buttonReserveRide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_place);
        fireStore = FirebaseFirestore.getInstance();
        viewLayout = findViewById(R.id.displayLayout);
        getData();
        setData();
        commonFields();
        buttonReserveRide = findViewById(R.id.addRide);
        buttonReserveRide.setOnClickListener((View.OnClickListener) this);
        bookRide();
    }

    private void getData() {
        if(getIntent().hasExtra("vehiclesList") & getIntent().hasExtra("vehiclePosition") & getIntent().hasExtra("images")) {

            vehicleArrayList = (ArrayList<Vehicle>) getIntent().getSerializableExtra("vehiclesList");


            ownerText = vehicleArrayList.get(position).getOwner();
            capacityAmount = vehicleArrayList.get(position).getCapacity();
            basePriceAmount = vehicleArrayList.get(position).getBasePrice();
            modelText = vehicleArrayList.get(position).getModel();
            vehicleTypeText = vehicleArrayList.get(position).getVehicleType();

//            if (vehicleArrayList.get(position).getVehicleType().equals("HeliCopter")) {
//                HeliCopter heliCopter = (HeliCopter) vehicleArrayList.get(position);
//            } else if (vehicleArrayList.get(position).getVehicleType().equals("Bycicle")) {
//                Bycicle bicycle = (Bycicle) vehicleArrayList.get(position);
//            } else if (vehicleArrayList.get(position).getVehicleType().equals("Car")) {
//                Car car = (Car) vehicleArrayList.get(position);
//            }
//            else if(vehicleArrayList.get(position).getVehicleType().equals("Segway"))
//            {
//                Segway segway = (Segway) vehicleArrayList.get(position);
//            }
//
//
//        } else {
//            Toast.makeText(this, "No data...", Toast.LENGTH_SHORT).show();
//        }
        }
    }

    public void commonFields() {
        viewLayout.removeAllViewsInLayout();
        owner = new TextView(this);
        viewLayout.addView(owner);
        model = new TextView(this);
        viewLayout.addView(model);
        capacity = new TextView(this);
        viewLayout.addView(capacity);
        vehicleType = new TextView(this);
        viewLayout.addView(vehicleType);
        basePrice = new TextView(this);
        viewLayout.addView(basePrice);

    }

    public void setData(){
        owner.setText("Owner: " + ownerText);
        capacity.setText("Available Sits: " + capacityAmount);
        model.setText("Model: " + modelText);
        basePrice.setText("$" + basePriceAmount);
        vehicleType.setText("VehicleType: "+ vehicleTypeText);
    }

    public void bookRide() {
        //close vehicle if user took last seat available
        if(vehicleArrayList.get(position).getCapacity() == 1) {
            fireStore.collection("vehicles").document(vehicleArrayList.get(position).getVehicleID())
                    .update("open", false);
        }

        // update capacity
        fireStore.collection("vehicles").document(vehicleArrayList.get(position).getVehicleID())
                .update("remainingCapacity", vehicleArrayList.get(position).getCapacity() - 1);

        // add user's uid to the list of reservedUids
        vehicleArrayList.get(position).getVehicleID();
        fireStore.collection("vehicles").document(vehicleArrayList.get(position).getVehicleID())
                .update("reservedUids", vehicleArrayList.get(position).getVehicleID())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // go back to VehiclesInfoActivity
                        Intent intent = new Intent(getApplicationContext(), VehicleInfo.class);
                        startActivity(intent);
                        finish();
                    }
                });
        // right here
    }

    public void onClick(View v) {
        int i = v.getId();
        if(i == buttonReserveRide.getId()) {
            bookRide();
        }
/*
        else if(i == buttonCancelRide.getID()) {
            cancelRide();
        }
*/
    }

}