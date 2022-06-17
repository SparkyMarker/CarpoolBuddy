package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

import java.util.ArrayList;

public class UserActivity2 extends AppCompatActivity {
   // private EditText uID;
    private EditText name;
    private EditText email;
    private EditText userType;
    private EditText priceMuiltiplier;
    private EditText ownedVehicles;
    private FirebaseFirestore fireStore;
    private Spinner userTypeSpinner;
    private LinearLayout userLayout;
    private EditText childrenUIDs;
    private EditText inSchoolTitle;
    private EditText graduatingYear;
    private EditText parentUIDs;
    private EditText graduateYear;
    private String selectedRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user2);
        userTypeSpinner = findViewById(R.id.userSpinner);
        userLayout = findViewById(R.id.userLayout);
        setupSpinner();
    }
    private void setupSpinner() {
        String[] typesOfUsers = {"User", "Teacher", "Student", "Parent", "Alumni"};
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(UserActivity2.this,
                android.R.layout.simple_spinner_item, typesOfUsers);
        langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userTypeSpinner.setAdapter(langArrAdapter);

        userTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        if (selectedRole.equals("Teacher")) {
            inSchoolTitle = new EditText(this);
            inSchoolTitle.setHint("Title in school");
            userLayout.addView(inSchoolTitle);
        }
        else if (selectedRole.equals("Student"))
        {
            graduatingYear = new EditText(this);
            graduatingYear.setHint("Graduating Year");
            userLayout.addView(graduatingYear);
            parentUIDs = new EditText(this);
            parentUIDs.setHint("parents user ID");
            userLayout.addView(parentUIDs);

        }
        else if (selectedRole.equals("Alumni")) {
            graduateYear = new EditText(this);
            graduateYear.setHint("Graduation Year");
            userLayout.addView(graduateYear);

        }
        else if (selectedRole.equals("Parent")){
            childrenUIDs = new EditText(this);
            childrenUIDs.setHint("Children's user ID");
            userLayout.addView(childrenUIDs);

        }
    }

    public void commonFields() {
//        userLayout.removeAllViewsInLayout();
//        uID = new EditText(this);
//        uID.setHint("User ID");
       // userLayout.addView(uID);
        name = new EditText(this);
        name.setHint("Name");
        userLayout.addView(name);
        email = new EditText(this);
        email.setHint("Email");
        userLayout.addView(email);
        userType = new EditText(this);
        userType.setHint("User Type");
        userLayout.addView(userType);
        priceMuiltiplier = new EditText(this);
        priceMuiltiplier.setHint("Price Multiplier");
        userLayout.addView(priceMuiltiplier);
        ownedVehicles = new EditText(this);
        ownedVehicles.setHint("Owned Vehicles");
        userLayout.addView(ownedVehicles);

    }

    public void nextScreen(View view) {

        //String userIDInput = uID.getText().toString();
        DocumentReference userID = fireStore.collection("Users").document();
        String userIDInput = userID.getId();

        String nameInput = name.getText().toString();
        String emailInput = email.getText().toString();
        String userTypeInput = userType.getText().toString();
        int priceMultiplierInput = Integer.parseInt(priceMuiltiplier.getText().toString());
        //String ownedVehiclesInput = ownedVehicles.getText().toString();


        try {
            fireStore = FirebaseFirestore.getInstance();



            if(selectedRole.equals("Teacher")){
                String inSchoolTitleInput = inSchoolTitle.getText().toString();
                Teacher teacher = new Teacher(userIDInput,nameInput,emailInput,userTypeInput,priceMultiplierInput, null, inSchoolTitleInput);
                //fireStore.collection("Users").document(userIDInput).set(teacher);
                userID.set(teacher);
            }
            else if (selectedRole.equals("Alumni")){
               int gradYearInput = Integer.parseInt(graduateYear.getText().toString());
               Alumni alumni = new Alumni(userIDInput,nameInput,emailInput,userTypeInput,priceMultiplierInput, null, gradYearInput);
                //fireStore.collection("Users").document(userIDInput).set(alumni);
                userID.set(alumni);
            }
            else if (selectedRole.equals("Parent"))
            {
               Parent parent = new Parent(userIDInput,nameInput,emailInput,userTypeInput,priceMultiplierInput, null, null);
                //fireStore.collection("Users").document(userIDInput).set(parent);
                userID.set(parent);
            }
            else if (selectedRole.equals("Student")){
                String graduatingYearInput = graduatingYear.getText().toString();
                Student student = new Student(userIDInput,nameInput,emailInput,userTypeInput,priceMultiplierInput, null, graduatingYearInput, null);
                //fireStore.collection("Users").document(userIDInput).set(student);
                userID.set(student);
            }
            else if(selectedRole.equals("User")){
                User user = new User(userIDInput,nameInput,emailInput,userTypeInput,priceMultiplierInput, null);
                //fireStore.collection("Vehicles").document(userIDInput).set(user);
                userID.set(user);
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
//        Intent nextScreen = new Intent(getBaseContext(), addVehicles.class);
//        startActivity(nextScreen);
    }

    public void next(View v){
        Intent nextScreen = new Intent(getBaseContext(), addVehicles.class);
        startActivity(nextScreen);
    }


}