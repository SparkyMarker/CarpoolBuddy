package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

public class UserProfile extends AppCompatActivity {

    private FirebaseFirestore fireStore;
    EditText userIDTextField;
    EditText nameTextField;
    EditText emailTextField;
    EditText userTypeTextField;
    EditText priceMultiplierTextField;
    EditText ownedVehiclesTextField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userIDTextField = (EditText) findViewById(R.id.userIDTextField);
        nameTextField = (EditText) findViewById(R.id.nameTextField);
        emailTextField = (EditText) findViewById(R.id.emailTextField);
        userTypeTextField = (EditText) findViewById(R.id.userTypeTextField);
        priceMultiplierTextField = (EditText) findViewById(R.id.priceMultiplierTextField);
        ownedVehiclesTextField = (EditText) findViewById(R.id.ownedVehiclesTextField);

    }
        public void nextScreen (View v){

        String userID = userIDTextField.getText().toString();
        String name = nameTextField.getText().toString();
        String email = emailTextField.getText().toString();
        String userType = userTypeTextField.getText().toString();
        int priceMultiplier = Integer.parseInt(priceMultiplierTextField.getText().toString());
        //String ownedVehicles = ownedVehiclesTextField.getText().toString();

       try {
           fireStore = FirebaseFirestore.getInstance();

           //User user = new User("ricky", "rikuto","rikuto_kimura@fis.edu", null, 10,null);
           User user = new User(userID, name,email, userType, priceMultiplier,null);

           fireStore.collection("UsersProfile").document("Ryder").set(user);
       }
       catch(Exception err)
       {
           err.printStackTrace();
       }


        //System.out.println(userID+name+email+userType+priceMultiplier+ownedVehicles);




//        Intent nextScreen = new Intent(getBaseContext(), VehicleInfo.class );
//        startActivity(nextScreen);
        }
        public void next(View ve){
            Intent nextScreen = new Intent(getBaseContext(), addVehicles.class );
             startActivity(nextScreen);
        }
}