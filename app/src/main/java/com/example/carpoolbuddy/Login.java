package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore fireStore;
    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth =  FirebaseAuth.getInstance();
        //fireStore = FirebaseFirestore.getInstance();
        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
    }

    public void signIn(View v){
        String emailString = emailField.getText().toString();
        String passwordString = passwordField.getText().toString();
        System.out.println(emailString + " "+ passwordString);
        System.out.println("login");
        mAuth.signInWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("SIGN IN", "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    //updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("SIGN IN", "signInWithEmail:failure", task.getException());
                    //updateUI(null);
                        }
                }
            });

         try
         {
         //User user = new User("ricky", "rikuto","rikuto_kimura@fis.edu", null, 10,null);



         }
         catch (Exception e)
         {
             System.out.println(e);
         }


        Intent nextScreen = new Intent(getBaseContext(), UserActivity2.class);
        if (emailString != null && passwordString != null) {
            startActivity(nextScreen);
        }
    }

    public void signUp(View v){
    System.out.println("create account");
        String emailString = emailField.getText().toString();
        String passwordString = passwordField.getText().toString();
        mAuth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("SIGN UP", "Successfully signed up user");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }
                else{
                    Log.w("SIGN UP", "signInWithCredential:failure", task.getException());
                    updateUI(null);
                }
            }
        });
        Intent nextScreens = new Intent(getBaseContext(), UserActivity2.class);
        if (emailString != null && passwordString != null){
            startActivity(nextScreens);
        }

    }

    public void updateUI(FirebaseUser currentUser){
        if(currentUser != null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Password Must be at least 6 characters", Toast.LENGTH_SHORT).show();
        }

    }

    public void next(View v){
        Intent nextScreens = new Intent(getBaseContext(), UserActivity2.class);
        startActivity(nextScreens);
    }

}