package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

//import com.example.carpoolbuddy.Models.Alumni;
//import com.example.carpoolbuddy.Models.User;
import com.example.carpoolbuddy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.firestore.FirebaseFirestore;

public class addVehicles extends AppCompatActivity {
    private FirebaseFirestore fireStore;
    private EditText owner;
    private EditText model;
    private EditText capacity;
    private EditText vehicleID;
    private EditText ridersUID;
    private EditText vehicleType;
    private EditText basePrice;
    private Spinner vehicleTypeSpinner;
    private LinearLayout viewLayout;
    private String selectedRole;
    private EditText range;
    private EditText weight;
    private EditText bycicleType;
    private EditText weightCapacity;
    private EditText maxAltitude;
    private EditText maxAirSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicles);
        fireStore = FirebaseFirestore.getInstance();
        viewLayout = findViewById(R.id.view);
        vehicleTypeSpinner = findViewById(R.id.spinner);
        setupSpinner();


    }

    private void setupSpinner() {
        String[] typesOfVehicles = {"Vehicle", "Helicopter", "Bycicle", "Segway", "Car"};
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(addVehicles.this,
                android.R.layout.simple_spinner_item, typesOfVehicles);
        langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpinner.setAdapter(langArrAdapter);

        vehicleTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedRole = adapterView.getItemAtPosition(i).toString();
                addFields();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void addFields() {
        commonFields();
        if (selectedRole.equals("Car")) {
            range = new EditText(this);
            range.setHint("Car Range");
            viewLayout.addView(range);
        }
        else if (selectedRole.equals("Bycicle"))
        {
            weight = new EditText(this);
            weight.setHint("Bike Weight");
            viewLayout.addView(weight);
            bycicleType = new EditText((this));
            bycicleType.setHint("type of bike");
            viewLayout.addView(bycicleType);
            weightCapacity = new EditText(this);
            weightCapacity.setHint("how much weight can it hold");
            viewLayout.addView(weightCapacity);

        }
        else if (selectedRole.equals("Segway")) {
            range = new EditText(this);
            range.setHint("Segway Range");
            viewLayout.addView(range);
            weightCapacity = new EditText(this);
            weightCapacity.setHint("how much weight can it hold");
            viewLayout.addView(weightCapacity);
        }
        else if (selectedRole.equals("Helicopter")){
           maxAltitude = new EditText(this);
           maxAltitude.setHint("Max Altitude");
           viewLayout.addView(maxAltitude);
           maxAirSpeed = new EditText(this);
           maxAirSpeed.setHint("Max Air Speed");
           viewLayout.addView(maxAirSpeed);
        }
    }

    public void commonFields() {
        viewLayout.removeAllViewsInLayout();
        owner = new EditText(this);
        owner.setHint("who is the owner of the vehicle");
        viewLayout.addView(owner);
        model = new EditText(this);
        model.setHint("Vehicle model");
        viewLayout.addView(model);
        capacity = new EditText(this);
        capacity.setHint("vehicle capacity");
        viewLayout.addView(capacity);
//        vehicleID = new EditText(this);
//        vehicleID.setHint("Vehicle ID");
//        viewLayout.addView(vehicleID);
//        ridersUID = new EditText(this);
//        ridersUID.setHint("rider's UID");
//        viewLayout.addView(ridersUID);
        vehicleType = new EditText(this);
        vehicleType.setHint("Type of Vehicle");
        viewLayout.addView(vehicleType);
        basePrice = new EditText(this);
        basePrice.setHint("Base Price");
        viewLayout.addView(basePrice);

    }



    public void addVehicles(View view) {
        String ownerName = owner.getText().toString();
        String modelName = model.getText().toString();
        int capacityInput = Integer.parseInt(capacity.getText().toString());
        //String vehicleIDInput = vehicleID.getText().toString();
        //String ridersUIDInput = ridersUID.getText().toString();
        String vehicleTypeInput = vehicleType.getText().toString();
        int basePriceInput = Integer.parseInt(basePrice.getText().toString());
        DocumentReference vehicleID = fireStore.collection("Vehicles").document();
        String vehicleIDInput = vehicleID.getId();


        //fireStore = FirebaseFirestore.getInstance();


        if (selectedRole.equals("Car")) {
            int rangeInput = Integer.parseInt(range.getText().toString());
            Car car = new Car(ownerName, modelName, capacityInput, vehicleIDInput, null, true, vehicleTypeInput, basePriceInput, rangeInput);
            //fireStore.collection("Vehicles").document(ownerName).set(car);
            vehicleID.set(car);
            System.out.println("I WORKED");
        } else if (selectedRole.equals("Segway")) {
            int rangeInput = Integer.parseInt(range.getText().toString());
            int weightCapacityInput = Integer.parseInt(weightCapacity.getText().toString());
            Segway segway = new Segway(ownerName, modelName, capacityInput, vehicleIDInput, null, true, vehicleTypeInput, basePriceInput, rangeInput, weightCapacityInput);
//          fireStore.collection("Vehicles").document(ownerName).set(segway);
            vehicleID.set(segway);
        } else if (selectedRole.equals("Bycicle")) {
            int weightInput = Integer.parseInt(weight.getText().toString());
            int weightCapacityInput = Integer.parseInt(weightCapacity.getText().toString());
            String bycicleTypeInput = bycicleType.getText().toString();
            Bycicle bycicle = new Bycicle(ownerName, modelName, capacityInput, vehicleIDInput, null, true, vehicleTypeInput, basePriceInput, bycicleTypeInput, weightInput, weightCapacityInput);
//            fireStore.collection("Vehicles").document(ownerName).set(bycicle);
            vehicleID.set(bycicle);
        } else if (selectedRole.equals("Helicopter")) {
            int maxAltitudeInput = Integer.parseInt(maxAltitude.getText().toString());
            int maxAirSpeedInput = Integer.parseInt(maxAirSpeed.getText().toString());
            HeliCopter heliCopter = new HeliCopter(ownerName, modelName, capacityInput, vehicleIDInput, null, true, vehicleTypeInput, basePriceInput, maxAltitudeInput, maxAirSpeedInput);
//          fireStore.collection("Vehicles").document(ownerName).set(heliCopter);
            vehicleID.set(heliCopter);
        } else if (selectedRole.equals("Vehicle")) {
            Vehicle vehicle = new Vehicle(ownerName, modelName, capacityInput, vehicleIDInput, null, true, vehicleTypeInput, basePriceInput);
//          fireStore.collection("Vehicles").document(ownerName).set(vehicle);
            vehicleID.set(vehicle);
        }
        //fireStore.collection("Vehicles").document(userID).set();

    }
    public void nextView (View v){
        Intent nextScreen = new Intent(getBaseContext(), VehicleInfo.class);
        startActivity(nextScreen);
    }
}
